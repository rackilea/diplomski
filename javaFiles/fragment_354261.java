public class Main {

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        // simulating a window of time where your method is invoked continuously
        for (int i = 0; i < 11; i++) {
            m.doSomething();
        }
        // shutting down executor when done
        m.terminate();
    }

    ExecutorService executor = Executors.newFixedThreadPool(5);

    // internally submits a new task to the executor
    public void doSomething() {
        executor.submit(new Runnable() {
            @Override
            public void run() {
                long wait = ThreadLocalRandom.current().nextLong(2000);
                try {
                    System.out.printf(
                        "%s is sleeping for %dms.%n", 
                        Thread.currentThread().getName(), 
                        wait
                    );
                    Thread.sleep(wait);
                }
                catch (InterruptedException ie) {
                    // suppressed
                }
                System.out.printf(
                    "%s is doing something!%n", 
                    Thread.currentThread().getName()
                );
            }
        });
    }

    public void terminate() throws Exception {
        executor.shutdown();
    }
}