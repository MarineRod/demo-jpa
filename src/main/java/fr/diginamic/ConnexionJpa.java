package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		Livre livreACreer = new Livre("Histoires extraordinaires", "Edgar Allan Poe");

		entityManager.persist(livreACreer);

		// Récupération
		Livre livre2 = entityManager.find(Livre.class, 5);
		if (null != livre2) {
			System.out.println(livre2);
		}

		// Récupération d'un emprunt numéro 2
		Emprunt emprunt = entityManager.find(Emprunt.class, 2);
		if (null != emprunt) {
			System.out.println(emprunt.getLivres());
		}

		// Récupération du client numéro 1
		Client client = entityManager.find(Client.class, 1);
		if (null != client) {
			System.out.println(client.getEmprunts());
		}

		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}
