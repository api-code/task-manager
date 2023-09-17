package com.bdiPlus.taskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;

import com.bdiPlus.taskManager.model.Task;
import com.bdiPlus.taskManager.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskServiceImpl implements TaskService {

	 	@Autowired
	    private TaskRepository taskRepository;
	    
	    @Override
	    public List<com.bdiPlus.taskManager.model.Task> findAll() {
	        return taskRepository.findAll();
	    }
	    
	    @Override
	    public com.bdiPlus.taskManager.model.Task findById(Long id) {
	    	 return taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found"));
	    }
	    
			@Override
		public com.bdiPlus.taskManager.model.Task save(com.bdiPlus.taskManager.model.Task task) {
				  return taskRepository.save(task);
		}

		@Override
		public void delete( Long id) {
			  taskRepository.delete( findById(id));
		}

		@Override
		public Task update(Long id, Task task) {
			 return taskRepository.save(task);
		}
     
		
}