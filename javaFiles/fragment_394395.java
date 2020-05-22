public class Main {

    static class MyThread extends Thread {
        public MyThread(String s) {
            super(s);
        }
        @Override
        public synchronized void run() {
            while(!Thread.interrupted()) {
                if (new Random().nextInt(1000000) == 7) {
                    throw new RuntimeException(Thread.currentThread().getName()+" oops!");
                }
            }
            System.out.println(Thread.currentThread().getName()+" interrupted");
        }
    }

    public static void main(String[] args) {
        final MyThread thread0 = new MyThread("thread0");
        final MyThread thread1 = new MyThread("thread1");
        final MyThread thread2 = new MyThread("thread2");

        Thread.UncaughtExceptionHandler h = (thread, exception) -> {
            System.out.println(exception.getMessage());
            thread0.interrupt();
            thread1.interrupt();
            thread2.interrupt();
        };
        thread0.setUncaughtExceptionHandler(h);
        thread1.setUncaughtExceptionHandler(h);
        thread2.setUncaughtExceptionHandler(h);

        thread0.start();
        thread1.start();
        thread2.start();
    }
}