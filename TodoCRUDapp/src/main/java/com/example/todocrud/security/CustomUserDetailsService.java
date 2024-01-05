package com.example.todocrud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.todocrud.repository.UserLoginRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userLoginRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found."));
	}

}
