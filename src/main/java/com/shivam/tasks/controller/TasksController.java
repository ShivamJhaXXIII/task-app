package com.shivam.tasks.controller;

import com.shivam.tasks.domain.dto.TaskDto;
import com.shivam.tasks.domain.entity.Task;
import com.shivam.tasks.mappers.TaskMapper;
import com.shivam.tasks.services.TaskService;
import com.shivam.tasks.services.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/task-list/{task_list_id}/tasks")
public class TasksController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final TaskServiceImpl taskServiceImpl;

    public TasksController(TaskService taskService, TaskMapper taskMapper, TaskServiceImpl taskServiceImpl) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
        this.taskServiceImpl = taskServiceImpl;
    }

    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id")UUID taskListId) {
        return taskService.listTasks(taskListId).stream().map(taskMapper::toDto).toList();
    }

    @PostMapping
    public TaskDto createTask(@PathVariable("task_list_id") UUID taskListId, @RequestBody TaskDto taskDto) {
        Task createdTask = taskService.createTask(taskListId,
                taskMapper.fromDto(taskDto));

        return taskMapper.toDto(createdTask);
    }

    @GetMapping("/{task_id}")
    public Optional<TaskDto> getTask(@PathVariable("task_list_id") UUID taskListId, @PathVariable("task_id") UUID taskId) {
        return taskService.getTask(taskListId, taskId).map(taskMapper::toDto);
    }

    @PutMapping("/{task_id}")
    public TaskDto updatedTask(@PathVariable("task_list_id") UUID taskListId
    ,@PathVariable("task_id") UUID taskId, @RequestBody TaskDto taskDto) {
        Task updatedTask = taskService.updateTask(
                taskListId,
                taskId,
                taskMapper.fromDto(taskDto)
        );

        return taskMapper.toDto(updatedTask);
    }

    @DeleteMapping("/{task_id}")
    public void deleteTask(
            @PathVariable("task_list_id") UUID taskListId
            ,@PathVariable("task_id") UUID taskId
    ) {
        taskService.deleteTask(taskListId, taskId);
    }
    
}
