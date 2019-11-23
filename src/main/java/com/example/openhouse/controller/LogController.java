package com.example.openhouse.controller;

import com.example.openhouse.models.Action;
import com.example.openhouse.models.Log;
import com.example.openhouse.repo.ActionRepository;
import com.example.openhouse.repo.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/logs")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLog(@Valid @RequestBody Log log){
        //System.out.println("Location X: "+log.getActions().get(0).getProperty().toString());
        logRepository.save(log);
    }

    @GetMapping("/logs")
    public Iterable<Log> getAllLogs(){
        return logRepository.findAll();
    }

    @GetMapping("/logsByUser/{user_id}")
    public Optional<List<Log>> getLogsByUserId(@PathVariable(value = "user_id") String user_id) {
        return logRepository.findLogsByUserId(user_id);
    }

    @GetMapping("/logsBySession/{session_id}")
    public Optional<List<Log>> getLogsBySessionId(@PathVariable(value = "session_id") String session_id) {
        return logRepository.findAllBySessionId(session_id);
    }

    /*@GetMapping("/logsByActionType/{type}")
    public Optional<List<Log>> getLogsByActionType(@PathVariable(value = "type") String type) {
        return logRepository
    }*/

}
