package ma.formations.jpa.service;

import java.util.List;

import ma.formations.jpa.service.model.Article;

public interface IService {
	
	Boolean checkAccount(String username,String password);
	List<Article> getAllArticle();
}
