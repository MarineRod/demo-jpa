package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		// je crée une banque
		Banque cic = new Banque("CIC");
		entityManager.persist(cic);

		// une opération
		Set<Operation> operations = new HashSet<>();
		Operation op1 = new Operation(LocalDateTime.now(), 200.00, "débit", null);
		Operation op2 = new Operation(LocalDateTime.now(), -50.0, "Retrait", null);
		operations.add(op1);
		operations.add(op2);
		entityManager.persist(cic);

		// un compte
		Compte cpt1 = new Compte("1564288A", 1300.00, operations);

		// Associer les opérations au compte
		op1.setCompte(cpt1);
		op2.setCompte(cpt1);

		// Persister le compte et les opérations
		entityManager.persist(cpt1);
		for (Operation op : operations) {
			entityManager.persist(op);
		}

		// un client
		Client client1 = new Client("Dupont", "Jeanne", LocalDate.of(1985, 5, 20),
				new Adresse(2, "Rue de l''Arche", 85000, "La Roche sur Yon"), cic);

		// Persister les clients
		entityManager.persist(client1);

		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}
