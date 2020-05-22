package multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MainThread {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Começando");
        Semaphore semaphore = new Semaphore(1);
        ExecutorService execService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 100; i++) {
            execService.submit(new BackgroundTask(semaphore, i));
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        for (int i = 0; i < 10; i++) {
            semaphore.acquire();
            System.out.print("$ ");
            line = reader.readLine();
            System.out.println(line);
            semaphore.release();
            Thread.sleep(1000);
        }
        reader.close();
        execService.awaitTermination(10, TimeUnit.MINUTES);
    }
}