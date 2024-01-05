package com.example.todocrud.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(unique = true)
    private String username;
    @Column
    private String password;
    
    //Unidirectional one to many relationship
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<Todo> todoList = new ArrayList<>();
    /**
     FetchType.EAGER in JPA means that when you retrieve an object (let's say, an author) from the database,
     you also want to eagerly retrieve and load all the related objects (like books written by that author)
     associated with it.
     Link:- https://www.baeldung.com/jpa-cascade-types
     **/
    
}
