package com.ab.roles.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDao {
	
	private final IUserDao userDao;
	
	public UserDetails findUserByEmail(String email) {
		com.ab.roles.entity.Users user = userDao.findByUserName(email);
		System.out.println("UserDao.findUserByEmail() " + user.getUserName());
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getRoleName()));});
		return new User(user.getUserName(), user.getPassword(), authorities);
	}

}
