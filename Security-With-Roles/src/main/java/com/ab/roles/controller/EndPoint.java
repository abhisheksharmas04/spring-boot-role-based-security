package com.ab.roles.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.roles.entity.Roles;
import com.ab.roles.entity.Users;
import com.ab.roles.service.UserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/api")
public class EndPoint {
	
	private final UserService userService;
	
	@GetMapping("/list-users")
	public ResponseEntity<List<Users>> getUsers(){
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@PostMapping("/save-user")
	public ResponseEntity<Users>saveUser(@RequestBody Users user){
		return ResponseEntity.ok().body(userService.saveUsers(user));
	}
	
	@PostMapping("/role-user")
	public ResponseEntity<Roles>saveRole(@RequestBody Roles role){
		return ResponseEntity.ok().body(userService.saveRole(role));
	}
	
	@PostMapping("/add-role-to-user")
	public ResponseEntity<?>addRole(@RequestBody RoleToUserForm form){
		userService.addRoleToUser(form.getUserName(), form.getRoleName());
		return ResponseEntity.ok().build();
	}
	

}

@Data
class RoleToUserForm{
	private String userName;
	private String roleName;
}