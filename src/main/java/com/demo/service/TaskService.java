package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.model.Task;
import com.demo.repository.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskRepo;
	
	public TaskService(TaskRepository taskRepo) 
	{
		this.taskRepo = taskRepo;
	}
	
	public List<Task> getAllTasks()
	{
		return taskRepo.findAll();
	}
	
	public Task getTaskById(Long id) 
	{
		return taskRepo.findById(id).orElse(null);
	}
	
	public Task CreateTask(Task task) 
	{
		task.setStatus("PENDING");
		return taskRepo.save(task);
	}
	
	public Task updateTask(Long id, Task taskDetails) 
	{
		Task task = taskRepo.findById(id).orElse(null);
		if(task!=null) 
		{
			task.setTitle(taskDetails.getTitle());
			task.setDescription(taskDetails.getDescription());
			task.setStatus(taskDetails.getStatus());
			task.setPriority(taskDetails.getPriority());
			return taskRepo.save(task);
		}
		return null;
	}
	public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
	
	public List<Task> getTasksByStatus(String status)
	{
		return taskRepo.findByStatus(status);
	}
	
	public List<Task> getTasksByPriority(String priority)
	{
		return taskRepo.findByPriority(priority);
	}
	
	public List<Task> searchTasks(String keyword)
	{
		return taskRepo.findByTitleContainingIgnoreCase(keyword);
	}
}
