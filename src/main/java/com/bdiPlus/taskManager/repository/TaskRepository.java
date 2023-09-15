package com.bdiPlus.taskManager.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
 

public interface TaskRepository extends JpaRepository<com.bdiPlus.taskManager.model.Task, Long> {
	List<com.bdiPlus.taskManager.model.Task> findAll();
     Optional<com.bdiPlus.taskManager.model.Task> findById(Long id);
     com.bdiPlus.taskManager.model.Task save(com.bdiPlus.taskManager.model.Task task);
    void delete(com.bdiPlus.taskManager.model.Task task);
}