package com.example.openhouse.controller;

import com.example.openhouse.models.Log;
import com.example.openhouse.repo.ActionRepository;
import com.example.openhouse.repo.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/*
  Log REST controller
  Author: Abhilash Paul
  Date: 22 Nov 2019
*/

@RestController
@RequestMapping("/logwebservice")
public class LogController {
  private LogRepository logRepository;
  private ActionRepository actionRepository;

  @Autowired
  public LogController(LogRepository logRepository, ActionRepository actionRepository){
    this.logRepository = logRepository;
    this.actionRepository = actionRepository;
  }

  //creates a log
  @PostMapping("/logs")
  @ResponseStatus(HttpStatus.CREATED)
  public void createLog(@Valid @RequestBody Log log){
    logRepository.save(log);
  }

  //retrieves all logs
  @GetMapping("/logs")
  public Iterable<Log> getAllLogs(){
    return logRepository.findAll();
  }

  //retrieves logs by user id
  @GetMapping("/logsByUser/{user_id}")
  public Optional<List<Log>> getLogsByUserId(@PathVariable(value = "user_id") String user_id) {
    return logRepository.findLogsByUserId(user_id);
  }

  //retrieves logs by session id
  @GetMapping("/logsBySession/{session_id}")
  public Optional<List<Log>> getLogsBySessionId(@PathVariable(value = "session_id") String session_id) {
    return logRepository.findAllBySessionId(session_id);
  }

  //retrieves logs by type
  @GetMapping("/logsByActionType/{type}")
  public Optional<List<Log>> getLogsByActionType(@PathVariable(value = "type") String type) {
      return logRepository.findLogsByLogActionType(type);
  }

}