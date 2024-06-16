package se.lexicon.g49todoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g49todoapi.domain.entity.Task;
import se.lexicon.g49todoapi.repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findTasksByPersonId(Long personId) {
        return taskRepository.findByPersonId(personId);
    }

    @Override
    public List<Task> findTasksBetweenStartAndEndDate(LocalDate startDate, LocalDate endDate) {
        return taskRepository.findByDeadlineBetween(startDate, endDate);
    }

    @Override
    public List<Task> findAllUnassignedTasks() {
        return taskRepository.findAllUnassignedTasks();
    }

    @Override
    public List<Task> findAllUnfinishedTasksAndOverdue(LocalDate currentDate) {
        return taskRepository.findAllUnfinishedAndOverdueTasks(currentDate);
    }
}
