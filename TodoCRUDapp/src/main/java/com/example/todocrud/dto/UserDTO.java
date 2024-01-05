package com.example.todocrud.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.todocrud.entity.Todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	    private String username;
	    private String password; 
	    private List<Todo> todoList = new ArrayList<>();
	    
}
