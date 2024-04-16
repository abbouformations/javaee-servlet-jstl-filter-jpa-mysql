package ma.formations.jpa.dao;

import java.util.List;

import ma.formations.jpa.service.model.User;

public interface IDao {
	User findById(Long id);
	void delete(Long id);
	List<User> findAllUsers();
	User getUserByUsername(String username);
	void save(User user);
	void deleteAll();
}
