package ma.formations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.formations.jpa.service.model.User;

public class DaoImplJPA implements IDao {
	private EntityManager session = null;

	@Override
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<>();
		try {
			session = DatabaseManager.getSessionFactory().createEntityManager();
			users=session.createQuery("from User").getResultList();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return users;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		try {
			session = DatabaseManager.getSessionFactory().createEntityManager();
			Query request=session.createQuery("select u from User u where u.username=:username");
			request.setParameter("username", username);
			List<User> liste=request.getResultList();
			if (liste != null && !liste.isEmpty())
				user=liste.get(0);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}

	@Override
	public void save(User user) {
		try {
			session = DatabaseManager.getSessionFactory().createEntityManager();
			EntityTransaction tx=session.getTransaction();
			tx.begin();
			session.merge(user);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
	}

	@Override
	public void deleteAll() {
		try {
			session = DatabaseManager.getSessionFactory().createEntityManager();
			EntityTransaction tx=session.getTransaction();
			tx.begin();
			session.createQuery("delete from User").executeUpdate();
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
	}

	@Override
	public User findById(Long id) {
		User user = null;
		try {
			session = DatabaseManager.getSessionFactory().createEntityManager();
			user=session.find(User.class,id);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}

	@Override
	public void delete(Long id) {
		try {
			session = DatabaseManager.getSessionFactory().createEntityManager();
			EntityTransaction tx=session.getTransaction();
			tx.begin();
			User userFoud=session.find(User.class,id);
			if (userFoud != null)
				session.remove(userFoud);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
