List<TaskFromFile> tasks = loadFileAndCreateTasks();
ExecutorService executor = Executors.newFixedThreadPool(50);

for(TaskFromFile task : tasks) {
    // createRunnable is not necessary in case your task implements Runnable
    executor.submit(createRunnable(task));
}

// assuming single-shot batch job
executor.shutdown();
executor.awaitTermination(MAX_WAIT_TIME_MILLIS, TimeUnit.MILLISECONDS);