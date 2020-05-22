ExecutorService executor = Executors.newFixedThreadPool(3);
final int taskId = 1;
executor.submit(new Runnable() {
    @Override
    public void run() {
        doSomething(taskId);
    }
});

executor.shutdown();