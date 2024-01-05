package com.example.todocrud.services;

import com.example.todocrud.dto.TodoDTO;
import com.example.todocrud.entity.Todo;
import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.ToDoRepository;
import com.example.todocrud.repository.UserRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TodoServices {

    @Autowired
    UserServices userServices;
    @Autowired
    ToDoRepository toDoRepository;
    @Autowired
    UserRepository userRepository;

    public Todo getTodoById(Long todoId){
        return toDoRepository.findById(todoId).orElse(null);
    }

    public void addTodo(Long userId, TodoDTO todoDTO){
    	Todo todo = new Todo();
    	todo.setContent(todoDTO.getContent());
    	todo.setCompleted(todoDTO.getCompleted());
    	
    	Users user = userServices.getUserById(userId);
        if(user != null) {
        	List<Todo> todoList = user.getTodoList();
        	todoList.add(todo);
        	user.setTodoList(todoList);
        	
        	toDoRepository.save(todo);  	
        }
    }
    public void deleteTodo(Long userId,Long todoId){
    	Users user = userServices.getUserById(userId);
    	if(user != null) {
    		List<Todo> todoList = user.getTodoList();
    		 Todo todoToDelete = todoList.stream()
    	                .filter(todo -> todo.getId() == todoId)
    	                .findFirst()
    	                .orElse(null);
    		 
    		 if (todoToDelete != null) {
    			    todoList.remove(todoToDelete);
    	            user.setTodoList(todoList);
    	            toDoRepository.deleteById(todoId);
    	        }
    		
    	}
    }

    public void toggleTodoCompleted(Long todoId){
        Todo todo = this.getTodoById(todoId);
        todo.setCompleted(!todo.getCompleted());
        toDoRepository.save(todo);
    }

    public void updateTodo(TodoDTO todoDTO) {
    	Todo todo = new Todo();
    	todo.setContent(todoDTO.getContent());
    	todo.setCompleted(todoDTO.getCompleted());
    	
    	toDoRepository.save(todo);
    }


}
