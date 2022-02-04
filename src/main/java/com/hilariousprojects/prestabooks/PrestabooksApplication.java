package com.hilariousprojects.prestabooks;

import com.hilariousprojects.prestabooks.domain.Role;
import com.hilariousprojects.prestabooks.domain.User;
import com.hilariousprojects.prestabooks.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class PrestabooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrestabooksApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_LIBRARIAN"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Dwight S","DelPuebloLibrary","123", new ArrayList<>()));
			userService.saveUser(new User(null,"Jim H","NewWorldLibrary","123", new ArrayList<>()));
			userService.saveUser(new User(null,"Mike Scott","LibAdmin","123", new ArrayList<>()));
			userService.saveUser(new User(null,"Andy B","LibUser1","123", new ArrayList<>()));

			userService.addRoleToUser("LibUser1","ROLE_USER");
			userService.addRoleToUser("DelPuebloLibrary","ROLE_LIBRARIAN");
			userService.addRoleToUser("NewWorldLibrary","ROLE_LIBRARIAN");
			userService.addRoleToUser("LibAdmin","ROLE_ADMIN");
			userService.addRoleToUser("LibAdmin","ROLE_SUPER_ADMIN");

		};
	}
}
