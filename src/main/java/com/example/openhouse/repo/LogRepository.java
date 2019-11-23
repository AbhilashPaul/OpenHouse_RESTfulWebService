package com.example.openhouse.repo;

import com.example.openhouse.models.Action;
import com.example.openhouse.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    Optional<List<Log>> findLogsByUserId(@Param("user_id") String userId);

    Optional<List<Log>> findAllBySessionId(@Param("session_id") String sessionId);

    //Optional<List<Log>>

}
