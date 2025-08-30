package com.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Task;
import com.demo.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	private final TaskService taskservice;
	
	public TaskController(TaskService taskservice) 
	{
		this.taskservice = taskservice;
	}
	
	@GetMapping
	public List<Task> getAllTask()
	{
		return taskservice.getAllTasks();
	}
	
	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable Long id) 
	{
		return taskservice.getTaskById(id);
	}
	@PostMapping
	public Task createTask(@RequestBody Task task) 
	{
		return taskservice.CreateTask(task);
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task task) 
	{
		return taskservice.updateTask(id, task);
	}
	
	  @DeleteMapping("/{id}")
	    public String deleteTask(@PathVariable Long id) {
	        taskservice.deleteTask(id);
	        return "Task deleted successfully!";
	    }
	  @GetMapping("/status/{status}")
	  public List<Task> getTaskByStatus(@PathVariable String status)
	  {
		  return taskservice.getTasksByStatus(status);
	  }
	  
	  @GetMapping("/priority/{priority}")
	  public List<Task> getTaskByPriority(@PathVariable String priority)
	  {
		  return taskservice.getTasksByPriority(priority);
	  }
	  @GetMapping("/search")
	  public List<Task> searchTasks(@RequestParam String keyword)
	  {
		  return taskservice.searchTasks(keyword);
	  }
}
