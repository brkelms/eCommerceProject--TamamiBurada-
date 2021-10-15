package JGoogle;

import Entity.Concrete.User;

public class JGoogleManager {
	
	public void signIn(User user)
	{
		System.out.println(user.getAd() + " Google hesabýnýzla baþarýyla giriþ yapýldý.");
	}

}
