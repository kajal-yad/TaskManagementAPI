package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{
	List<Task> findByStatus(String status);
	List<Task> findByPriority(String priority);
	List<Task> findByTitleContainingIgnoreCase(String keyword);
}
