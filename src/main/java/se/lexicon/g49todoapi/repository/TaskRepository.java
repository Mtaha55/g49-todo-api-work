package se.lexicon.g49todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.g49todoapi.domain.entity.Task;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Select tasks that contain the given title (case insensitive)
    List<Task> findByTitleContainingIgnoreCase(String title);

    // Select tasks by person's id
    @Query("SELECT t FROM Task t WHERE t.person.id = :personId")
    List<Task> findByPersonId(@Param("personId") Long personId);

    // Select tasks by status
    List<Task> findByDone(boolean done);

    // Select tasks by date between start and end
    List<Task> findByDeadlineBetween(LocalDate startDate, LocalDate endDate);

    // Select all unassigned tasks
    @Query("SELECT t FROM Task t WHERE t.person IS NULL")
    List<Task> findAllUnassignedTasks();

    // Select all unfinished tasks
    @Query("SELECT t FROM Task t WHERE t.done = false")
    List<Task> findAllUnfinishedTasks();

    // Select all unfinished and overdue tasks
    @Query("SELECT t FROM Task t WHERE t.done = false AND t.deadline < :currentDate")
    List<Task> findAllUnfinishedAndOverdueTasks(@Param("currentDate") LocalDate currentDate);

}
