package com.example.todocrud.services;

import com.example.todocrud.dto.UserDTO;
import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public Users getUserById (Long userId){
    	return userRepository.findById(userId).orElse(null);
    }

    public void addUser(UserDTO userdto){
    	Users user = new Users();
    	user.setUsername(userdto.getUsername());
    	user.setPassword(userdto.getPassword());
    	user.setTodoList(userdto.getTodoList());
    	
    	userRepository.save(user);
    }

    public void deleteUser(Long userId){
    	userRepository.deleteById(userId);
    }

    public void updateUser(UserDTO userdto, Long userId){
    	Users user = getUserById(userId);
    	if(user != null) {
    		user.setUsername(userdto.getUsername());
        	user.setPassword(userdto.getPassword());
        	user.setTodoList(userdto.getTodoList());
        	
        	userRepository.save(user);
    	}
 	
    }

}
