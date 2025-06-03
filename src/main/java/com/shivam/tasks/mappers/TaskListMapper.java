package com.shivam.tasks.mappers;

import com.shivam.tasks.domain.dto.TaskListDto;
import com.shivam.tasks.domain.entity.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
