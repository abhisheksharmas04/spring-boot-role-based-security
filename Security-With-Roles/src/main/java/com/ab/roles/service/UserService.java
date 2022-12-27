package com.ab.roles.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ab.roles.dao.IRolesDao;
import com.ab.roles.dao.IUserDao;
import com.ab.roles.entity.Roles;
import com.ab.roles.entity.Users;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor  @Transactional
public class UserService implements IUserService {
	private final IUserDao userDao;
	private final IRolesDao roleDao;

	@Override
	public Users saveUsers(Users user) {
		return userDao.save(user);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		Users user = userDao.findByUserName(userName);
		Roles role = roleDao.findByRoleName(roleName);
		user.getRoles().add(role);

	}

	@Override
	public Users getUser(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public List<Users> getUsers() {
		return userDao.findAll();
	}

	@Override
	public Roles saveRole(Roles role) {
		return roleDao.save(role);
	}

}
