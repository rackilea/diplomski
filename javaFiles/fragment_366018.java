public class ThreadDemo implements Runnable {
    public static Integer num = 1;

    public static final Object lock = new Object();

    public ThreadDemo() {
    }

    @Override
    public void run() {

        try {
            while (true) {
                int count = 0;
                synchronized (lock) {
                    Thread.sleep(100);
                    while (count < 2) {
                        System.out.println(Thread.currentThread().getName() + "  " + num++);
                        count++;

                    }
                    lock.notify();
                    lock.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CoWorkingThreads {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadDemo(), "First");
        thread1.start();
        Thread thread2 = new Thread(new ThreadDemo(), "Second");
        thread2.start();
    }
}