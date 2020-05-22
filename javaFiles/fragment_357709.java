package com.bts.poc;

import com.bts.poc.service.DynamicCron;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ScheduledFuture;

@SpringBootApplication(exclude = MessageSourceAutoConfiguration.class)
@EnableScheduling
@RestController
public class Application extends SpringBootServletInitializer {

    @Autowired
    private DynamicCron dynamicCron;
    @Autowired
    private PropertyManager propertyManager;
    private static List<ScheduledFuture> scheduledFutures = new ArrayList<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private static TaskScheduler scheduler;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    private String cronConfig() {
        return propertyManager.getProperty("COMPANY", "JOB_NAME", "CRON_EXPRESSION");
    }

    @RequestMapping(value = {"scheduling/start"}, method = RequestMethod.GET)
    public @ResponseBody String startScheduling() {
        scheduleAll();

        LOGGER.info("Scheduling of jobs has been started.");
        return "Scheduling of jobs has been started.";
    }

    @RequestMapping(value = {"scheduling/cancel"}, method = RequestMethod.GET)
    public @ResponseBody String cancelScheduling() {
        cancelAll();

        LOGGER.info("Cancelling all scheduled jobs.");
        return "Cancelling all scheduled jobs.";
    }

    private void scheduleAll() {
        LOGGER.info("Scheduling all applications to run.");
        cancelAll();

        //eventually go through the database and load all jobs to be scheduled here.
        schedule(cronConfig());
    }

    /**
     * Cancel all the scheduled reports
     */
    private void cancelAll() {
        for (ScheduledFuture scheduledFuture : scheduledFutures) {
            scheduledFuture.cancel(true);
        }
        scheduledFutures.clear();
    }

    /**
     * Schedule the scheduled report with the given cron schedule information
     */
    private void schedule(String cronSchedule) {
        TimeZone tz = TimeZone.getDefault();
        LOGGER.info("Setting up application {} to execute with cron string: '{}'.", cronSchedule);
        CronTrigger trigger = new CronTrigger(cronSchedule, tz);

        scheduler = scheduler();
        if (scheduler == null) {
            LOGGER.error("Unable to schedule job as scheduler was not found");
            return;
        }

        ScheduledFuture<?> future = scheduler.schedule(new DynamicCron(), trigger);
        scheduledFutures.add(future);
    }

    @Bean
    public TaskScheduler scheduler() {
        if (scheduler == null) {
            ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
            scheduler.setPoolSize(10);
            scheduler.afterPropertiesSet();
        }
        return scheduler;
    }
}