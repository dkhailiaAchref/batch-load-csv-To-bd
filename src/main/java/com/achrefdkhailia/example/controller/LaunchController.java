package com.achrefdkhailia.example.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.achrefdkhailia.example.repository.UserRepository;
@RestController
public class LaunchController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Autowired UserRepository userRepository;

    @GetMapping
    @RequestMapping("/load")
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {


        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("JobExecution: " + jobExecution.getStatus());

        System.out.println("Batch is Running...");
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }

        return jobExecution.getStatus();
    }

    @GetMapping
    @RequestMapping("/purge")
    public String purgeDb(){
        Long nbRows=userRepository.count();
        userRepository.deleteAll();
        String result="Data deleted from H2 Database /table user, " + nbRows.intValue() +"rows deleted ";
        return result;
    }
}
