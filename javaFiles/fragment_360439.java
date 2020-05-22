public Task getNextTask(BlockingQueue<Task> queue) {
boolean interrupted = false;
try {
    while (true) {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            interrupted = true;
            // fall through and retry
        }
    }
} finally {
    if (interrupted)
        Thread.currentThread().interrupt();
}
}