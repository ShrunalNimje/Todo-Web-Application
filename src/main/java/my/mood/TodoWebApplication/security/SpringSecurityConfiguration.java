package my.mood.TodoWebApplication.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails...user)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails = createNewUser("Shrunal", "dummy");
		UserDetails userDetails1 = createNewUser("Adam", "dummy");
		UserDetails userDetails2 = createNewUser("Shakira", "dummy");
		
		return new InMemoryUserDetailsManager(userDetails, userDetails1, userDetails2);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private UserDetails createNewUser(String username, String password) {
		Function <String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
										.passwordEncoder(passwordEncoder)
										.username(username)
										.password(password)
										.roles("USER", "ADMIN")
										.build();
		return userDetails;
	}
}
