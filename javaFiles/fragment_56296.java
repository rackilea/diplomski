import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Semaphores {

    static Object LOCK = new Object();

    static LinkedList list = new LinkedList();
    static Semaphore sem = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);

    static class Consumer extends Thread {
        String name;
        public Consumer(String name) {
            this.name = name;
        }
        public void run() {
            try {

                while (true) {
                    sem.acquire(1);
                    mutex.acquire();
                    System.out.println("Consumer \""+name+"\" read: "+list.removeFirst());
                    mutex.release();
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }

    static class Producer extends Thread {
        public void run() {
            try {

                int N = 0;

                while (true) {
                    mutex.acquire();
                    list.add(new Integer(N++));
                    mutex.release();
                    sem.release(1);
                    Thread.sleep(500);
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }

    public static void main(String [] args) {
        new Producer().start();
        new Consumer("Alice").start();
        new Consumer("Bob").start();
    }
}