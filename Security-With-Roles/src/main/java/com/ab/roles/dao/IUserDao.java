package com.ab.roles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.roles.entity.Users;

public interface IUserDao extends JpaRepository<Users, Integer> {
	Users findByUserName(String email);

}
