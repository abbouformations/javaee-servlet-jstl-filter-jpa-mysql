
package ma.formations.jpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {
	private static EntityManagerFactory sessionFactory;

	private DatabaseManager() {

	}

	public static EntityManagerFactory getSessionFactory() {
		if (sessionFactory != null)
			return sessionFactory;
		try {
			sessionFactory = Persistence.createEntityManagerFactory("unite1");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sessionFactory;
	}
}
