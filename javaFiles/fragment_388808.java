package multithread;

import java.util.concurrent.Semaphore;

public class BackgroundTask implements Runnable {

    private Semaphore semaphore;

    private int id;

    public BackgroundTask(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                semaphore.acquire();
                System.out.println("Hello from " + id);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}