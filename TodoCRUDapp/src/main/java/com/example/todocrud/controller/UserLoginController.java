package com.example.todocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.todocrud.dto.LoginUserDTO;
import com.example.todocrud.entity.LoginUser;
import com.example.todocrud.services.UserLoginService;

@RestController
@RequestMapping("/user")
public class UserLoginController {
	
	@Autowired
	UserLoginService userLoginService;
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('ADMIN")
	public List<LoginUser> getAllUsers() {
		return userLoginService.getAllUsers();
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public void registerUser(@RequestBody LoginUserDTO loginUserDto) {
		userLoginService.registerUser(loginUserDto);
	}
}
