package test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Lochy {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition producers = lock.newCondition();
        Condition consumers = lock.newCondition();

        while (true) {
            try {
                try {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("wait " + i);
                        consumers.await(500, TimeUnit.MILLISECONDS);
                    }
                    producers.signal();
                } finally {
                    lock.unlock();
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}