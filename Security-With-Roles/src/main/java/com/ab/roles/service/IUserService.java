package com.ab.roles.service;

import java.util.List;

import com.ab.roles.entity.Roles;
import com.ab.roles.entity.Users;

public interface IUserService {
	Users saveUsers(Users users);
	Roles saveRole(Roles role);
	void addRoleToUser(String userName, String roleName);
	Users getUser(String userName);
	List<Users>getUsers();

}
