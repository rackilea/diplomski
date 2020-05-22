// Total tries
int tries = 3;
// Current total of tries
int tryCount = 1;
do {
    // My fake task to execute asynchronously
    FutureTask<Void> task = new FutureTask<>(
        () -> {
            Thread.sleep(2000);
            return null;
        }
    );
    // Submit the task to the thread pool
    executor.submit(task);
    try {
        // Wait for a result during at most 1 second
        task.get(1, TimeUnit.SECONDS);
        // I could get the result so I break the loop
        break;
    } catch (TimeoutException e) {
        // The timeout has been reached
        if (tryCount++ == tries) {
            // Already tried the max allowed so we throw an exception
            throw new RuntimeException(
                String.format("Could execute the task after %d tries", tries),
                e
            );
        }
    }
} while (true);