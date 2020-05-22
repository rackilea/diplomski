public class Test {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1,
                TimeUnit.MINUTES, new LinkedBlockingQueue<>(), r -> {
                    Thread thread = new Thread(r);
                    thread.setUncaughtExceptionHandler((t, e) -> {
                        synchronized(System.out) {
                            System.out.println("Uncaught exception in "+t.getId());
                            e.printStackTrace(System.out);
                        }
                    });
                    System.out.println("created thread with id " + thread.getId());
                    return thread;
        });
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getId() + " started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + " termination");
            throw new RuntimeException();
            };
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.shutdown();
    }
}