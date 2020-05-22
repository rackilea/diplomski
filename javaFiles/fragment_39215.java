package com.hemal.spring;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


public class SpringScheduleCronExample {
    private AtomicInteger counter = new AtomicInteger(0);

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

        return new PropertySourcesPlaceholderConfigurer();
    } 

    @Scheduled(cron = "${cron.expression}")
    public void cronJob() {
        int jobId = counter.incrementAndGet();
        System.out.println("Job @ cron " + new Date() + ", jobId: " + jobId);
    }

    public static void main(String[] args) {
           AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                   SpringScheduleCronExample.class);
        try {
            Thread.sleep(24000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
           context.close();
        }
    }
}