package com.learn.stackoverflow.multithreading;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 
 * @author himanshu.agrawal
 *
 */
public class ExecutorServiceNumberOfThreads {
    public static void main(String[] args) {
        System.out.println("### Testing Executors.newFixedThreadPool()");
        testNewFixedThreadPool();
    }

    private static void testNewFixedThreadPool() {
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        System.out.println("Pool when no execute() : " + poolExecutor.getPoolSize());
        executeRunnable(poolExecutor);
        System.out.println("Pool after 1st execute() : " + poolExecutor.getPoolSize());
        executeRunnable(poolExecutor);
        System.out.println("Pool after 2nd execute() : " + poolExecutor.getPoolSize());
        executeRunnable(poolExecutor);
        System.out.println("Pool after 3rd execute() : " + poolExecutor.getPoolSize());
        executeRunnable(poolExecutor);
        System.out.println("Pool after 4th execute() : " + poolExecutor.getPoolSize());
        executeRunnable(poolExecutor);
        System.out.println("Pool after 5th execute() : " + poolExecutor.getPoolSize());
    }

    private static void executeRunnable(ThreadPoolExecutor poolExecutor) {
        poolExecutor.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("Running: " + Thread.currentThread().getId() + " | " + new Date());
            }
        });
    }

}