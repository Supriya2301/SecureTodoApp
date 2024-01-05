package com.example.todocrud.controller;

import com.example.todocrud.dto.TodoDTO;
import com.example.todocrud.dto.UserDTO;
import com.example.todocrud.entity.Todo;
import com.example.todocrud.entity.Users;
import com.example.todocrud.services.TodoServices;
import com.example.todocrud.services.UserServices;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
	
    private final TodoServices todoServices;
    private final UserServices userServices;

    // Constructor dependency injection
    public UserController(UserServices userServices,TodoServices todoServices){
        this.userServices = userServices;
        this.todoServices = todoServices;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyRole('NORMAL', 'ADMIN')")
    public Users getUserById(@PathVariable Long userId){
        return userServices.getUserById(userId);
    }

    @GetMapping("/todo/{todoId}")
    @PreAuthorize("hasAnyRole('NORMAL', 'ADMIN')")
    public Todo getTodoById(@PathVariable Long todoId){
        return todoServices.getTodoById(todoId);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('NORMAL', 'ADMIN')")
    public void addUser(@RequestBody UserDTO userRequest){
        userServices.addUser(userRequest);
    }

    @PostMapping("/{userId}/todos")
    @PreAuthorize("hasAnyRole('NORMAL', 'ADMIN')")
    public void addTodo(@PathVariable Long userId, @RequestBody TodoDTO todoDTO){
        todoServices.addTodo(userId,todoDTO);
    }

    @PostMapping("/todos/{todoId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void toggleTodoCompleted(@PathVariable Long todoId){
        todoServices.toggleTodoCompleted(todoId);
    }

    @PutMapping("/update/user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateUser(@RequestBody UserDTO user, @PathVariable Long userId){
        userServices.updateUser(user, userId);
    }

    @PutMapping("/todo")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateTodo(@RequestBody TodoDTO todo){
        todoServices.updateTodo(todo);
    }

    @DeleteMapping("{userId}/todos/{todoId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTodo(@PathVariable Long userId,@PathVariable Long todoId){
        todoServices.deleteTodo(userId,todoId);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long userId){
        userServices.deleteUser(userId);
    }
}
