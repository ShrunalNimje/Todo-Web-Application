package my.mood.TodoWebApplication.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@RequestMapping(value = "login", 
			method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "login",
			method = RequestMethod.POST)
	public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(authenticationService.isCorrect(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
//		else {
//			model.put("Error message : ", "Invalid Credentials! Please try again.");
//		return "login";
//		}
		
		model.put("ErrorMessage", "Invalid Credentials! Please try again.");
		return "login";
	}
}
