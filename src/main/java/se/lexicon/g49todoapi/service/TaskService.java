package se.lexicon.g49todoapi.service;

import se.lexicon.g49todoapi.domain.entity.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    // Create a new task
    Task create(Task task);

    // Find a task by its ID
    Optional<Task> findById(Long id);

    // Update an existing task
    Task update(Task task);

    // Delete a task by its ID
    void delete(Long id);

    // Find tasks by person's ID
    List<Task> findTasksByPersonId(Long personId);

    // Find tasks between start and end dates
    List<Task> findTasksBetweenStartAndEndDate(LocalDate startDate, LocalDate endDate);

    // Find all unassigned tasks
    List<Task> findAllUnassignedTasks();

    // Find all unfinished and overdue tasks
    List<Task> findAllUnfinishedTasksAndOverdue(LocalDate currentDate);
}
