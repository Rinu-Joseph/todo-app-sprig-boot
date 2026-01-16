package com.ust.todoappspringboot.repository;

import com.ust.todoappspringboot.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findTaskByStatusIs(Task.Status status);
    @Query(" FROM Task WHERE dueDate < CURDATE() AND status != 'completed'")
    List<Task> findTaskByOverdue();
    @Modifying
    @Query("update Task t set t.status=:status where t.id=:id")
    int updateTaskById(Task.Status status,int id);
    @Query("from Task order by dueDate")
    List<Task> getTaskInSortedDueDate();

    List<Task> findByDeleted(boolean deleted);
}
