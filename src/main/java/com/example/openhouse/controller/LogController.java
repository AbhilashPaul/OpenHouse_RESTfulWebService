package com.example.openhouse.controller;

import com.example.openhouse.models.Log;
import com.example.openhouse.repo.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public LogController(LogRepository logRepository){
        this.logRepository = logRepository;
    }

    @PostMapping("/logs")
    public ResponseEntity createLog(@Valid @RequestBody Log log){
        System.out.println(log.toString());
        logRepository.save(log);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/logs")
    public List<Log> getAllLogs(){
        return logRepository.findAll();
    }

}
