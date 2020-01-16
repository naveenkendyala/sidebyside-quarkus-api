package com.quarkus.demo.sidebyside.controller;

import io.agroal.api.AgroalDataSource;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.quarkus.demo.sidebyside.entity.ToDo;

@Path("todos")
@ApplicationScoped
public class ToDoController {

	@Inject
	AgroalDataSource dataSource;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ToDo> getAllTodos() {
		return ToDo.listAll();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public List<ToDo> persistTodo() {
		return ToDo.listAll();
	}

}