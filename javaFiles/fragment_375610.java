ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
final Runnable actualTask = null;

executorService.scheduleAtFixedRate(new Runnable() {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private Future<?> lastExecution;
    @Override
    public void run() {
        if (lastExecution != null && !lastExecution.isDone()) {
            return;
        }
        lastExecution = executor.submit(actualTask);
    }
}, 10, 10, TimeUnit.MINUTES);