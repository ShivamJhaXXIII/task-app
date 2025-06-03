package com.shivam.tasks.domain.dto;

import com.shivam.tasks.domain.entity.TaskPriority;
import com.shivam.tasks.domain.entity.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
){
}
