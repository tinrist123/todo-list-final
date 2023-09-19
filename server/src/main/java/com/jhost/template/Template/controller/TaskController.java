package com.jhost.template.Template.controller;

import com.jhost.template.Template.model.Task;
import com.jhost.template.Template.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TasksService tasksService;

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public ResponseEntity<List<Task>> GetTasksByUserId(@PathVariable long userId)
    {
        try {
            var tasks = tasksService.GetTasksByUserId(userId);

            return ResponseEntity.ok(tasks);

        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(null);
        }

    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<Long> CreateTask(@RequestBody Task task)
    {
        try {
            var taskId = tasksService.CreateTaskByUserId(task);

            return ResponseEntity.ok(taskId);

        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(null);
        }

    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public ResponseEntity<Long> UpdateTaskByUserId(@RequestBody Task task)
    {
        try {
            var taskId = tasksService.UpdateTaskByUserId(task);

            return ResponseEntity.ok(taskId);

        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(null);
        }

    }

    @RequestMapping(value = "/field",method = RequestMethod.PUT)
    public ResponseEntity<Long> UpdateIsDoneTask(@RequestBody Task task)
    {
        try {
            var a = tasksService.UpdateIsDone(task.getTaskid(), task.getIsDone());

            return ResponseEntity.ok(a);

        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(null);
        }

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Long> DeleteTaskByLstId(@PathVariable long id)
    {
        try {
            tasksService.DeleteTaskByLstId(id);

            return ResponseEntity.ok(1L);

        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(null);
        }

    }
}
