package com.bdiPlus.taskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.bdiPlus.taskManager.model.Task ;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdiPlus.taskManager.service.TaskService;
import com.bdiPlus.taskManager.service.TaskServiceImpl;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
  
	 @Autowired
	    private TaskService taskService;
	    
	    @GetMapping
	    public List<com.bdiPlus.taskManager.model.Task> getTasks() {
	        return taskService.findAll();
	    }
	    
	    @GetMapping("/{id}")
	    public com.bdiPlus.taskManager.model.Task getTask(@PathVariable Long id) {
	        return taskService.findById(id);
	    }
	    
	    @PostMapping
	    public com.bdiPlus.taskManager.model.Task createTask(@RequestBody Task task) {
	        return taskService.save(task);
	    }
	    
	    @PutMapping("/{id}")
	    public com.bdiPlus.taskManager.model.Task updateTask(@PathVariable Long id, @RequestBody Task task) {
	        return taskService.update(id, task);
	    }
	    
	    @DeleteMapping("/{id}")
	    public void deleteTask(@PathVariable Long id) {
	        taskService.delete(id);
	    }
}