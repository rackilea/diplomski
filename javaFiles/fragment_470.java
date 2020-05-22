private Map<Path, ScheduledFuture> futures = new HashMap<>();

private ScheduledExecutorService executor = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

private static final TimeUnit UNITS = TimeUnit.SECONDS; // your time unit

public void scheduleForDeletion(Path path, long delay) {
    ScheduledFuture future = executor.schedule(() -> {
        try {
            Files.delete(path);
        } catch (IOException e) {
            // failed to delete
        }
    }, delay, UNITS);

    futures.put(path, future);
}

public void onFileAccess(Path path) {
    ScheduledFuture future = futures.get(path);
    if (future != null) {

        boolean result = future.cancel(false);
        if (result) {
            // reschedule the task
            futures.remove(path);
            scheduleForDeletion(path, future.getDelay(UNITS));
        } else {
            // too late, task was already running
        }
    }
}