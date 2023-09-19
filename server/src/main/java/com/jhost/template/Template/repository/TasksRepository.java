package com.jhost.template.Template.repository;

import com.jhost.template.Template.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task,Long> {

    List<Task> findByUserid(long userid);

    @Modifying
    @Query(countQuery = "UPDATE Task SET is_done = ?2 WHERE taskid = ?1" , nativeQuery = true)
    @Transactional
    void updateIsdone(long taskid, int isDone);
}
