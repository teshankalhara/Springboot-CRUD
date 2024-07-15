package com.example.springintro.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;
    // primary key

    @Column(nullable = false)
    private String taskName;

    @Column(nullable = false)
    private Integer priority;

    private LocalDateTime dueDate;

    /*
     * lombok use for getter and setters
     * public void setTaskName(String taskName) {
     * this.taskName = taskName;
     * }
     * 
     * public String getTaskName() {
     * return this.taskName;
     * }
     * 
     * public void setPriority(Integer priority) {
     * this.priority = priority;
     * }
     * 
     * public Integer getPriority() {
     * return priority;
     * }
     * 
     * public LocalDateTime getDueDate() {
     * return dueDate;
     * }
     * 
     * public void setDueDate(LocalDateTime dueDate) {
     * this.dueDate = dueDate;
     * }
     */
}
