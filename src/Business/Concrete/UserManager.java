package Business.Concrete;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Business.Abstract.UserService;
import Core.GoogleService;
import DataAccess.Abstract.UserDao;
import Entity.Concrete.User;

public class UserManager implements UserService {
	
	List<String> mailList = new ArrayList<String>();
	List<User> userList = new ArrayList<User>();

	private UserDao userDao;
	private GoogleService googleService;
	
	public UserManager(UserDao userDao,GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.googleService=googleService;
	}

	@Override
	public boolean mailVerification(User user) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getEposta());
		if(matcher.matches()==true && mailList.contains(user.getEposta())==false){
			mailList.add(user.getEposta());
			return true;
		}
		else{
			return false;
		}
	}


	@Override
	public boolean passwordVerification(User user) {
		String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\\\s]).{6,}"; 
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getParola());
		if(matcher.matches()==true){
			return true;
		}
		else{
			return false;
		}
	}	
	
	@Override
	public boolean nameVerification(User user) {
		String regex = "[0-9a-zA-Z]{2,}";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getAd());
	    Matcher matcherLastName = pattern.matcher(user.getSoyad());
		if(matcher.matches()==true && matcherLastName.matches()==true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean gmailVerification(User user) {
		String regex = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getEposta());
		if(matcher.matches()==true && mailList.contains(user.getEposta())==false)
		{
			mailList.add(user.getEposta());
			return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public void sigIn(User user) {
		if(mailVerification(user)==true && nameVerification(user)==true && passwordVerification(user)==true){
			this.userDao.signIn(user);
			userList.add(user);
		}
		else {
			System.out.println("Lütfen Tüm Bilgileri Doldurunuz");
		}
		
	}

	@Override
	public void logIn(User user) {
		if(userList.contains(user) && user.getEposta() != null && user.getParola() != null){
			this.userDao.logIn(user);
		}
		else {
			System.out.println("Yanlýþ eposta adresi veya þifre");
		}		
	}

	@Override
	public void signInWithGoogle(User user) {
		if(gmailVerification(user) == true && nameVerification(user)==true && passwordVerification(user)==true){
			this.googleService.signInWithGoogle(user);
			userList.add(user);
		}
		else {
			System.out.println("Lütfen Google Hesabýnýzla Oturum Açýn.");
		}
		
		
	}
	
	public void deleteUser(User user) {
		if(userList.contains(user)) {
			this.userDao.deleteUser(user);
		} else {
			System.out.println("Henüz oturum açmadýnýz!");
		}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
