final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
for (int i = 0; i < 1000; i++)
    executor.submit(new Callable<Void>() {
        @Override
        public Void call() throws Exception {
            Thread.sleep(2);
            return null;
        }
    });
while (executor.getQueue().size() > 0) {
    System.out.println("Queue " + executor.getQueue().size() + ", Pool size " + executor.getPoolSize());
    Thread.sleep(200);
}
executor.setCorePoolSize(0);
while (executor.getPoolSize() > 0) {
    System.out.println("Pool size " + executor.getPoolSize());
    Thread.sleep(200);
}
System.out.println("Pool size " + executor.getPoolSize());