public class ThreadTest {
    private static int counter = 0;

    private static class Thread1 extends Thread {
        final Object lock;

        public Thread1(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++)
                    counter += i;
            }
        }
    }

    private static class Thread2 extends Thread {
        final Object lock;

        public Thread2(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++)
                    counter += i;
            }
        }
    }

    public static void main(String[] args) {
        final Object lock = new Object();

        final Thread th1 = new Thread1(lock);
        final Thread th2 = new Thread2(lock);

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter);
    }
}