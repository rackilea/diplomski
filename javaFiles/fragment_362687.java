package com.stackoverflow.q2413389;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

    public static void main(String... args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<String>> results = executor.invokeAll(Arrays.asList(new Task()));
        for (Future<String> result : results) {
            System.out.println(result.get()); // Prints "myResult" after 2 seconds.
        }
        executor.shutdown();
    }

}

class Task implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(2000); // Do your running task here, this example lasts 2 seconds.
        return "myResult";
    }

}