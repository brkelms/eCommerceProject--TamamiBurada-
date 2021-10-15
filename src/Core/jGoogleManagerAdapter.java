package Core;

import Entity.Concrete.User;
import JGoogle.JGoogleManager;

public class jGoogleManagerAdapter implements GoogleService {

	@Override
	public void signInWithGoogle(User user) {
		JGoogleManager googleManager=new JGoogleManager();
		googleManager.signIn(user);
		
	}



}
