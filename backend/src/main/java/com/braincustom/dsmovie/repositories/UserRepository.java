package com.braincustom.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braincustom.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//busca no BD por email
	User findByEmail(String email);
}
