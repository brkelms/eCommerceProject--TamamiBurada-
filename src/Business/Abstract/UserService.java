package Business.Abstract;

import java.util.List;

import Entity.Concrete.User;

public interface UserService {
	
	boolean mailVerification(User user);
	boolean passwordVerification(User user);
	boolean nameVerification(User user);
	void sigIn(User user);
	void logIn(User user);
	void signInWithGoogle(User user);
	void deleteUser(User user);
	List<User> getAll();

}
