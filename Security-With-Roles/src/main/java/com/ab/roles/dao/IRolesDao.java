package com.ab.roles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.roles.entity.Roles;

public interface IRolesDao extends JpaRepository<Roles, Integer> {
	Roles findByRoleName(String roleName);

}
