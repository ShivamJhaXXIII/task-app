package com.shivam.tasks.mappers;

import com.shivam.tasks.domain.dto.TaskDto;
import com.shivam.tasks.domain.entity.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
