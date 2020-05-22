// 1. init executor
int numberOfThreads = 2; // or any other number
int numberOfTasks = numberOfThreads; // is this true in your case?
ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

long startTime = System.currentTimeMillis();

// 2. execute tasks in parallel using executor
for(int i = 0; i < numberOfTasks; i++) {
    executor.execute(new Task()); // Task is your implementation of Runnable
}

// 3. initiate shutdown and wait until all tasks are finished
executor.shutdown();
executor.awaitTermination(1, TimeUnit.MINUTES); // we won't wait forever

// 4. measure time
long delta = System.currentTimeMillis() - startTime;