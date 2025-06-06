package com.shivam.tasks.services;

import com.shivam.tasks.domain.entity.TaskList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskListService {
    List<TaskList> listTaskList();
    TaskList createTaskList(TaskList taskList);
}
