package com.blt;

public class ThreadExample implements Runnable {
    public static void main(String args[]) {
        Thread T1 = new Thread(new ThreadExample());
        Thread T2 = new Thread(new ThreadExample());
        try {
            T1.setName("thread 1");
            T1.start();
            T2.setName("thread 2");
            T2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {

        synchronized (ThreadExample.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    ThreadExample.class.notify();
                    System.out.println("Thread going to wait state::"+ Thread.currentThread().getName());
                    ThreadExample.class.wait(400);
                    System.out.println("Thread notified is::"+ Thread.currentThread().getName());
                    System.out.println("Thread going to sleep state::"+ Thread.currentThread().getName());
                    Thread.sleep(2000);
                    System.out.println("==========");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}