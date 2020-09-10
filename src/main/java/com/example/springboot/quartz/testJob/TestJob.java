package com.example.springboot.quartz.testJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.time.LocalDateTime;

public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("@@@@@@@@@@@@@");
        System.out.println(LocalDateTime.now());
    }
}
