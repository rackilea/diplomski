int numberOfTasks = strArray.length;
ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
try {
    for (int i = 0; i < numberOfTasks; i++) {
        executor.execute(new MyRunnable(strArray[i], resultSet));
    }
} catch (Exception err) {
    err.printStackTrace();
}
executor.shutdown();