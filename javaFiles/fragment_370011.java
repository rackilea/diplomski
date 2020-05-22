public class App {

    static volatile boolean ready = false;
    static volatile int data = -1;

    private static class Reader implements Runnable {

        private final Lock lock;
        private final Condition condition;

        public Reader(Lock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while (!ready) {
                    try {
                        condition.await();
                    } catch (InterruptedException ex) {
                        //oh well
                    }
                }
                System.out.println(data);
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Writer implements Runnable {

        private final Lock lock;
        private final Condition condition;

        public Writer(Lock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                data = 42;
                ready = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        executorService.execute(new Reader(lock, condition));
        executorService.execute(new Writer(lock, condition));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}