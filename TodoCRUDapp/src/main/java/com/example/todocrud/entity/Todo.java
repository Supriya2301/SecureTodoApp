package com.example.todocrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private String content;
    @Column
    private Boolean completed = false;

}
