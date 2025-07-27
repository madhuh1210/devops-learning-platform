package com.yourdomain.devops.tasksapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // No extra methods needed for basic CRUD
}
