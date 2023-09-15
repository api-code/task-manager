package com.bdiPlus.taskManager.service;

import java.util.List;

//import org.springframework.stereotype.Service;

import com.bdiPlus.taskManager.model.Task;

public interface TaskService {
	List< com.bdiPlus.taskManager.model.Task> findAll();
	com.bdiPlus.taskManager.model.Task findById(Long id);
	com.bdiPlus.taskManager.model.Task save(com.bdiPlus.taskManager.model.Task task);
    void delete(Long id);
//    com.bdiPlus.taskManager.model.Task update(  com.bdiPlus.taskManager.model.Task  task);
	Task update(Long id, Task task);
	 
}
