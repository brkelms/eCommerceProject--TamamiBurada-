import Business.Abstract.UserService;
import Business.Concrete.UserManager;
import Core.jGoogleManagerAdapter;
import DataAccess.Abstract.UserDao;
import DataAccess.Concrete.UserActionsDao;
import Entity.Concrete.User;

public class Main {

	public static void main(String[] args) {
		
		UserService userService= new UserManager(new UserActionsDao(),new jGoogleManagerAdapter());
		User burak1 = new User(1,"burak","elmas","deneme1@gmail.com","5pO115-");
		User burak2 = new User(1,"burak","elmas","deneme2@gmail.com","5p9115-");
		User burak3 = new User(1,"burak","elmas","deneme3@hotmail.com","5p8315-");
		User burak4 = new User(1,"burak","elmas","deneme4@gmail.com","123144");
		User burak5 = new User(1,"burak","elmas","deneme5@gmail.com","1Ab-");
		User burak6 = new User(1,"a","bb","deneme6@gmail.com","5p8315-");

		userService.sigIn(burak1);
		userService.signInWithGoogle(burak2);
		userService.signInWithGoogle(burak3);
		userService.logIn(burak1);
		userService.logIn(burak2);
		userService.logIn(burak3);
		
		userService.deleteUser(burak2);
		userService.logIn(burak2);
		
		userService.sigIn(burak4);
		userService.sigIn(burak5);
		userService.sigIn(burak6);
	}
}

	


