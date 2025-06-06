package com.shivam.tasks.controller;

import com.shivam.tasks.domain.dto.TaskListDto;
import com.shivam.tasks.domain.entity.TaskList;
import com.shivam.tasks.mappers.TaskListMapper;
import com.shivam.tasks.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/task-list")
public class TaskListController {
    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping("/all")
    public List<TaskListDto> listTaskList() {
        List<TaskListDto> list = taskListService.listTaskList().stream()
                .map(taskListMapper::toDto)
                .toList();

        return list;

    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList taskList = taskListMapper.fromDto(taskListDto);

        return taskListMapper.toDto(taskListService.createTaskList(taskList));
    }
}
