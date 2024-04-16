package ma.formations.jpa.dao.article;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ma.formations.jpa.dao.DatabaseManager;
import ma.formations.jpa.service.model.Article;

public class ArticleDaoImplJPA implements IArticleDao {
	private EntityManager session;

	@Override
	public List<Article> findAll() {
		List<Article> articles = new ArrayList<Article>();
		try {
			session = DatabaseManager.getSessionFactory().createEntityManager();
			articles = session.createQuery("from Article").getResultList();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return articles;
	}
	
	@Override
	public void save(Article article) {
		try {
			session = DatabaseManager.getSessionFactory().createEntityManager();
			EntityTransaction tx=session.getTransaction();
			tx.begin();
			session.merge(article);
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
			session.createQuery("delete from Article").executeUpdate();
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
	public Article findById(Long id) {
		Article article = null;
		try {
			session = DatabaseManager.getSessionFactory().createEntityManager();
			article=session.find(Article.class,id);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return article;
	}

	@Override
	public void delete(Long id) {
		try {
			session = DatabaseManager.getSessionFactory().createEntityManager();
			EntityTransaction tx=session.getTransaction();
			tx.begin();
			Article articleFound=session.find(Article.class,id);
			if (articleFound != null)
				session.remove(articleFound);
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
