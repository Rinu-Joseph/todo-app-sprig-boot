package com.ust.todoappspringboot.service;

import com.ust.todoappspringboot.model.Task;
import com.ust.todoappspringboot.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//POST /api/v1/tasks: Create a new task.
@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Task saveTask(Task task)
    {

        return taskRepository.save(task);
    }

    public List<Task> getAllTask()
    {
        return taskRepository.findByDeleted(false);
    }

    public Task findTaskById(int id)
    {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTaskByStatus(Task.Status status)
    {
        return taskRepository.findTaskByStatusIs(status);
    }

    public List<Task> getAllOverdueTasks()
    {
        return taskRepository.findTaskByOverdue();
    }

    @Transactional
    public int updateTaskById(int id,Task.Status status)
    {
        return taskRepository.updateTaskById(status,id);
    }

    public void deleteTaskById(int id)
    {
        Task task=findTaskById(id);
        if(task!=null)
        {
            task.setDeleted(true);
            taskRepository.deleteById(id);
            taskRepository.save(task);
        }

    }

    public List<Task> getTaskBySortedDueDate()
    {
        return taskRepository.getTaskInSortedDueDate();
    }


    public List<Task> getDeletedTask()
    {
        return taskRepository.findByDeleted(true);
    }
}
