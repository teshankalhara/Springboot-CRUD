package com.example.springintro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springintro.entity.Task;

@Service
public interface TaskService {
    // what do we except to do this task
    List<Task> getTasksList();

    Task createTask(Task task);

}
