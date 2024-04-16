package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImplJPA;
import ma.formations.jpa.dao.IDao;
import ma.formations.jpa.dao.article.ArticleDaoImplJPA;
import ma.formations.jpa.dao.article.IArticleDao;
import ma.formations.jpa.service.model.Article;
import ma.formations.jpa.service.model.User;

public class Test {
	public static void main(String[] args) {
		IDao dao = new DaoImplJPA();
		dao.deleteAll();
		dao.save(User.builder().username("user01").password("user01").build());
		dao.save(User.builder().username("user02").password("user02").build());
		dao.save(User.builder().username("user03").password("user03").build());
		dao.save(User.builder().username("user04").password("user04").build());
		dao.save(User.builder().username("user05").password("user05").build());

		IArticleDao daoArticle = new ArticleDaoImplJPA();
		daoArticle.deleteAll();
		daoArticle.save(Article.builder().description("PC PRTABLE HP").price(30D).quantite(15000d).build());
		daoArticle.save(Article.builder().description("PC PRTABLE DELL").price(20d).quantite(12000.0).build());
		daoArticle.save(Article.builder().description("TV LG").price(100.0).quantite(7500.0).build());
		daoArticle.save(Article.builder().description("TV SONY").price(10.0).quantite(8500.0).build());
		daoArticle.save(Article.builder().description("CAMERA SONY").price(12.0).quantite(2500.0).build());
		daoArticle.save(Article.builder().description("DD 100G").price(27.0).quantite(500.0).build());
	}
}
