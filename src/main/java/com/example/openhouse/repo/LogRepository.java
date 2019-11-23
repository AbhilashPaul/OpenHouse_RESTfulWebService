package com.example.openhouse.repo;

import com.example.openhouse.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
  Log Repository
  Author: Abhilash Paul
  Date: 22 Nov 2019
*/

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    //method to retrieve logs by user id
    Optional<List<Log>> findLogsByUserId(@Param("user_id") String userId);

    //method to retrieve logs by session id
    Optional<List<Log>> findAllBySessionId(@Param("session_id") String sessionId);

    //method to retrieve logs by action type
    //not working yet
    @Query("SELECT l FROM Log l JOIN l.actions a where a.type = :#{#type}")
    Optional<List<Log>> findLogsByLogActionType(@Param("type") String type);

}
