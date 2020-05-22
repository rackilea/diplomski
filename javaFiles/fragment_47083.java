Public class TestClass{
    static AtomicInteger counter = new AtomicInteger();

    static class MyExceptionHandler implements UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("caught");
            if (counter.get() == 3) {
                System.out.println("Reached Max. retries, exiting");
            } else {
                counter.incrementAndGet();
                new Thread(new MyTask()).start();
            }

        }
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.currentThread().setUncaughtExceptionHandler(new MyExceptionHandler());
                System.out.println("slept");
                Thread.sleep(500);
                double d = 0 / 0;
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String args[]) throws Exception {
        Thread thread = new Thread(new MyTask());
        thread.start();
    }
}