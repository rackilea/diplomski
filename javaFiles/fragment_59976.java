package dev.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBehaviorDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {

            public void run() {
                System.out.println("All threads Arrived at barrier Checkpoint");
            }

        });

        Thread t1= new Thread(new Task(barrier),"thread-1");
        Thread t2= new Thread(new Task(barrier),"thread-2");
        Thread t3= new Thread(new Task(barrier),"thread-3");
        Thread t4= new Thread(new Task(barrier),"thread-4");
        Thread t5= new Thread(new Task(barrier),"thread-5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}

class Task implements Runnable {
    CyclicBarrier barrier;

    Task(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " has started for checkpoint 1");
            barrier.await();

            System.out.println(Thread.currentThread().getName() + " has started for checkpoint 2");
            barrier.await();

            System.out.println(Thread.currentThread().getName() + " has started for checkpoint 3");
            barrier.await();

            System.out.println(Thread.currentThread().getName() + "has finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}