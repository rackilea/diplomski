import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Solution {

    static int shared = 0;
    static boolean flag = true;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; ++i) {
                    lock.lock();
                    while (flag == false) {
                        try {
                            condition.await();  // wait until thread2 set true
                        } catch (InterruptedException e) {

                        }
                    }
                    System.out.println("thread" + 1 + " : shared = " + shared++);
                    flag = false;
                    condition.signalAll();
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; ++i) {
                    lock.lock();
                    while (flag == true) {
                        try {
                            condition.await(); // wait until thread1 set false
                        } catch (InterruptedException e) {

                        }
                    }
                    System.out.println("thread" + 2 + " : shared = " + shared++);
                    flag = true;
                    condition.signalAll();
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
    }
}