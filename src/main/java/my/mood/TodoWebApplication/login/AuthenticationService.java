package my.mood.TodoWebApplication.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean isCorrect(String name, String password) {
		boolean isValidName = name.equals("Adam");
		boolean isValidPassword = password.equals("asd");
		
		return isValidName && isValidPassword;
	}
}
