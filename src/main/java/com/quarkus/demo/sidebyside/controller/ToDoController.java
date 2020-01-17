package com.quarkus.demo.sidebyside.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.agroal.api.AgroalDataSource;

import com.quarkus.demo.sidebyside.entity.ToDo;
import com.quarkus.demo.sidebyside.repository.ToDoRepository;

@RestController
public class ToDoController {

	@Autowired
	private ToDoRepository todoRepository;	

	@Inject
	AgroalDataSource defaultDataSource;

	@GetMapping("/todos")
	public List<ToDo> getAllToDos() {
		return todoRepository.findAll();
	}

	@GetMapping("/applive")
	public String liveCheck() {
		return "OK";
	}

	@GetMapping("/appready")
	public String healthCheck() {
		return "OK";
	}

	@PutMapping("/todos")
	public List<ToDo> addToDo(@RequestBody ToDo todo) {

		todoRepository.save(todo);
		return todoRepository.findAll();
	}
	
//Using CrudRepository	
//	@GetMapping("/todos")
//	public List<ToDo> getAllToDos() {
//		List<ToDo> todos = new ArrayList<ToDo>();
//		todoRepository.findAll().forEach(todos::add);
//		return todos;
//	}

}
