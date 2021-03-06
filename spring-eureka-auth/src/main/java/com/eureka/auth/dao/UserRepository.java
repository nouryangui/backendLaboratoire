package com.eureka.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.auth.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUsername(String username);

	AppUser findByEmail(String email);

}
