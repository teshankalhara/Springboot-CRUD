package com.example.springintro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springintro.entity.Task;

//repository layer--->dao layer
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // custom queries can be define here
}
