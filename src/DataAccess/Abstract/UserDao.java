package DataAccess.Abstract;

import java.util.List;

import Entity.Concrete.User;

public interface UserDao {
	
	User get(int id);
	List<User> getAll();
	void signIn(User user);
	void logIn(User user);
	void deleteUser(User user);
}
