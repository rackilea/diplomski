package com.ggl.testing;

public class TimerRunnable implements Runnable {

    private static final long interval = 40L; // 40 milliseconds

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            update();
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            elapsedTime = Math.max((interval - elapsedTime), 5L);
            sleep(elapsedTime);
            startTime = System.currentTimeMillis();
        }
    }

    private void sleep(long interval) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {

        }
    }

    private void update() {

    }

}