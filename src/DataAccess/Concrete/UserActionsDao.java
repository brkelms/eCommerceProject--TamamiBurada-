package DataAccess.Concrete;

import java.util.List;

import DataAccess.Abstract.UserDao;
import Entity.Concrete.User;

public class UserActionsDao implements UserDao{

	@Override
	public void signIn(User user) {
		System.out.println("Eposta adresinize mesaj gönderildi, kontrol ediniz. " + user.getEposta());		
	}

	@Override
	public void logIn(User user) {
		System.out.println(user.getEposta() + " giriþ baþarýyla yapýldý.");
	}

	@Override
	public void deleteUser(User user) {
		System.out.println(user.getEposta() + " silindi.");
		user.setAd(null);
		user.setId(0);
		user.setSoyad(null);
		user.setEposta(null);
		user.setParola(null);		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
