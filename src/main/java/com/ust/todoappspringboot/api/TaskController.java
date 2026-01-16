package com.ust.todoappspringboot.api;

import com.ust.todoappspringboot.model.Task;
import com.ust.todoappspringboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//GET /api/v1/tasks: Retrieve a list of all tasks.

//POST /api/v1/tasks: Create a new task.
//GET /api/v1/tasks/{id}: Retrieve a specific task by its ID.
//GET /api/v1/tasks/status: Retrieve tasks based on their status (e.g., PENDING, COMPLETED).
//GET /api/v1/tasks/overdue: Retrieve all overdue tasks.
//PUT /api/v1/tasks/{id}: Update a specific task by its ID.
//DELETE /api/v1/tasks/{id}: Delete a specific task by its ID.
//GET /api/v1/tasks/sort: Retrieve tasks sorted by due date
//GET /api/v1/tasks/deleted : Retrieve all deleted tasks
@RestController
@RequestMapping
public class TaskController {
 @Autowired
    TaskService taskService;

    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task)
    {
        return taskService.saveTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTask()
    {
        return taskService.getAllTask();
    }
    @GetMapping("/tasks/{id}")
    public Task findTaskById(@PathVariable int id)
    {
        return taskService.findTaskById(id);
    }
    @GetMapping("/tasks/status")
    public List<Task> getTaskByStatus(@RequestParam Task.Status status)
    {
        return taskService.getTaskByStatus(status);
    }
    @GetMapping("/tasks/overdue")
    public List<Task> getAllOverdueTasks()
    {
return taskService.getAllOverdueTasks();
    }
@PutMapping("/tasks/{id}")
    public int updateTaskById(@PathVariable int id, @RequestParam Task.Status status)
{
    return taskService.updateTaskById(id,status);
}
@DeleteMapping("/tasks/{id}")
    public void deleteTaskByid(@PathVariable int id)
{
 taskService.deleteTaskById(id);
}
@GetMapping("/tasks/sort")
    public List<Task> getTaskBySortedDuedate()
{
    return taskService.getTaskBySortedDueDate();
}
@GetMapping("/tasks/deleted")
    public List<Task> getDeletedTasks()
{
    return taskService.getDeletedTask();
}
}
