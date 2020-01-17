package com.quarkus.demo.sidebyside.repository;

import com.quarkus.demo.sidebyside.entity.ToDo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoRepository extends JpaRepository<ToDo, Integer>{

}