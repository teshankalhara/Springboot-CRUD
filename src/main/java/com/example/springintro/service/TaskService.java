package com.example.springintro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springintro.entity.Task;

@Service
public interface TaskService {
    // what do we except to do this task
    List<Task> getTasksList(); // reading

    Task createTask(Task task); // creating

    Task getTaskById(Long id); // get by specific id

    Task updateTask(Long id, Task task); // get by specific id and update

    void deleteTask(Long id); // delete task using task id
}
