package com.example.todocrud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todocrud.entity.LoginUser;

public interface UserLoginRepository extends JpaRepository<LoginUser, Long> {

	Optional<LoginUser> findByUsername(String username);	
}
