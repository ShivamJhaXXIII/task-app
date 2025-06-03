package com.shivam.tasks.mappers.impl;

import com.shivam.tasks.domain.dto.TaskDto;
import com.shivam.tasks.domain.entity.Task;
import com.shivam.tasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public Task fromDto(TaskDto taskDto) {
        return new Task(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                null,
                taskDto.dueDate(),
                null,
                taskDto.status(),
                taskDto.priority(),
                null
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getTaskPriority(),
                task.getTaskStatus()
        );
    }
}
