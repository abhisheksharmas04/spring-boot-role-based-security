package com.ab.roles;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ab.roles.entity.Roles;
import com.ab.roles.entity.Users;
import com.ab.roles.service.UserService;

import lombok.RequiredArgsConstructor;

//@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
	
	private final UserService userService;

	@Override
	public void run(String... args) throws Exception {
		Roles r1 = new Roles();
		r1.setRoleName("Admin");
		
		Roles r2 = new Roles();
		r2.setRoleName("Student");
		
		userService.saveRole(r1);
		userService.saveRole(r2);
		
		Users u1 = new Users();
		u1.setUserName("John");
		u1.setPassword("123456");
		u1.setRoles(new ArrayList<>());
		
		Users u2 = new Users();
		u2.setUserName("Jim");
		u2.setPassword("94563");
		u2.setRoles(new ArrayList<>());
		
		userService.saveUsers(u1);
		userService.saveUsers(u2);
		
		userService.addRoleToUser("John", "Admin");
		
		/*
		 * userService.saveUsers(new Users(null,"John", "123456", new ArrayList<>()));
		 * userService.saveUsers(new Users(null,"Jim", "94563", new ArrayList<>()));
		 * 
		 * userService.addRoleToUser("John", "Admin");
		 */

	}

}
