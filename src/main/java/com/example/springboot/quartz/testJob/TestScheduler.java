package com.example.springboot.quartz.testJob;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestScheduler {

    @PostConstruct
    public void start() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        // job 지정
        JobDetail job = JobBuilder.newJob(TestJob.class).withIdentity("Test Job").build();

        // Trigger 생성
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(
                CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();

        scheduler.scheduleJob(job, trigger);
    }
}
