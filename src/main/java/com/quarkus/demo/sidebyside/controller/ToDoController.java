package com.quarkus.demo.sidebyside.controller;

import org.springframework.web.bind.annotation.RestController;

import io.agroal.api.AgroalDataSource;

import java.util.List;

import javax.inject.Inject;

import com.quarkus.demo.sidebyside.entity.ToDo;
import com.quarkus.demo.sidebyside.repository.ToDoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ToDoController{

    @Autowired
    ToDoRepository toDoRepository;

    @Inject
    AgroalDataSource dataSource;

    @GetMapping(value="/todos")
    public List<ToDo> getAllTodos() {
        return toDoRepository.findAll();
    }    

    @PutMapping("/todos")
    public List<ToDo> persistToDo(@RequestBody ToDo toDo){
        toDoRepository.save(toDo);
        return toDoRepository.findAll();
    }

}