private final BlockingQueue<MyRunnable> queue = new ArrayBlockingQueue<>();
// if you want to shutdown your threads with a boolean
private volatile boolean shutdown;
...

// threads running in the `ExecutorService` will be doing this run() method
public void run() {
    // this allows them to maintain state, in this case your writer
    BufferedWriter writer = ...;
    while (!shutdown && !Thread.currentThread.isInterrupted()) {
        // they get their tasks from your own queue
        MyRunnable runnable = queue.take();
        // if you are using a poison pill but you'll have to add X of them
        if (runnable == STOP_OBJECT) {
            break;
        }
        runnable.run();
    }
    writer.close();
}