package com.quarkus.demo.sidebyside.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ToDo {

	//Use @GeneratedValue for automatically generating the Id
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="TASK_NAME")
	private String task;
	
	@Column(name="IS_COMPLETE")
    private boolean isComplete;
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}