package banque;

import java.time.LocalDateTime;
import java.time.LocalDate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa2 {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		// Insérer un compte associé à 2 clients
		Client client1 = entityManager.find(Client.class, 1);
		Client client2 = entityManager.find(Client.class, 2);
		Compte compte1 = new Compte();
		compte1.getClients().add(client1);
		compte1.getClients().add(client2);
		entityManager.persist(compte1);

		Banque cic = new Banque("CIC");
		entityManager.persist(cic);

		// Insérer un client avec plusieurs comptes
		Client client3 = new Client("Durand", "Bertrand", LocalDate.of(1970, 8, 12),
				new Adresse(3, "Rue de la République", 85000, "La Roche sur Yon"), cic);
		LivretA livretA = new LivretA();
		AssuranceVie assuranceVie = new AssuranceVie();
		client3.getComptes().add(livretA);
		client3.getComptes().add(assuranceVie);
		entityManager.persist(client3);

		// Insérer des opérations de type virements sur un compte
		Compte compte2 = entityManager.find(Compte.class, 2);
		Virement virement = new Virement("Jacques Dupuis", LocalDateTime.now(), 300.00, "Dépôt", compte2);
		compte2.getOperations().add(virement);
		entityManager.persist(virement);

		// Insérer des opérations de type opérations sur un compte
		Compte compte3 = entityManager.find(Compte.class, 3);
		Operation operation = new Operation();
		compte3.getOperations().add(operation);
		entityManager.persist(operation);

		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}