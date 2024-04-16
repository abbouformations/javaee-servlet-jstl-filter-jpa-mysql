package ma.formations.jpa.service;

import java.util.List;

import ma.formations.jpa.dao.DaoImplJPA;
import ma.formations.jpa.dao.IDao;
import ma.formations.jpa.dao.article.ArticleDaoImplJPA;
import ma.formations.jpa.dao.article.IArticleDao;
import ma.formations.jpa.service.model.Article;
import ma.formations.jpa.service.model.User;

public class ServiceImpl implements IService {
	private IDao dao = new DaoImplJPA();
	private IArticleDao daoArticle = new ArticleDaoImplJPA();

	@Override
	public Boolean checkAccount(String username, String password) {
		User u = dao.getUserByUsername(username);
		if (u == null)
			return false;
		return (password.equals(u.getPassword()));
	}

	@Override
	public List<Article> getAllArticle() {
		return daoArticle.findAll();
	}

}
