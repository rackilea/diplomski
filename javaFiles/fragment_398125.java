private final AtomicBoolean runningBackgroundTask = new AtomicBoolean(false);

private void runBackgroundTask() {

    if (runningBackgroundTask.getAndSet(true)) {
        System.out.println("This task will be ignored because the thread pool is busy.");
        return;
    }

    Runnable backgroundTask = new Runnable() {

        @Override
        public void run() {
            // Do something that takes time...
            runningBackgroundTask.set(false);
        }
    };

    backgroundTaskExecutor.submit(backgroundTask);
}