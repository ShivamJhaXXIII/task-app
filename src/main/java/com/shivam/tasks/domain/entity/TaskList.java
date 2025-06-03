package com.shivam.tasks.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="task_list")
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    private UUID id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "taskList", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Task> tasks;

    @Column(name="created", nullable = false)
    private LocalDateTime created;

    @Column(name="last_updated", nullable = false)
    private LocalDateTime updated;
}
