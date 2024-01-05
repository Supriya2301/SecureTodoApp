package com.example.todocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todocrud.dto.LoginUserDTO;
import com.example.todocrud.entity.LoginUser;
import com.example.todocrud.repository.UserLoginRepository;

@Service
public class UserLoginService {

	@Autowired
	UserLoginRepository userLoginRepository;
	
	public List<LoginUser> getAllUsers() {
		return userLoginRepository.findAll();
	}

	public void registerUser(LoginUserDTO loginUserDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(loginUserDto.getPassword());
		
		LoginUser user = new LoginUser();
		user.setUsername(loginUserDto.getUsername());
		user.setPassword(encodedPassword);
	
		userLoginRepository.save(user);	
	}

	
}
