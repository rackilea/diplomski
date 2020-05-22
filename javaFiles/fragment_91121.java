private final class ChildExecutor implements Executor, Runnable {
    private final Queue<Runnable> tasks = QueueFactory
            .createQueue(Runnable.class);
    private final AtomicBoolean isRunning = new AtomicBoolean();

    public void execute(Runnable command) {
        // TODO: What todo if the add return false ?
        tasks.add(command);

        if (!isRunning.get()) {
            doUnorderedExecute(this);
        } else {
        }
    }

    public void run() {
        // check if its already running by using CAS. If so just return
        // here. So in the worst case the thread
        // is executed and do nothing
        boolean acquired = false;
        if (isRunning.compareAndSet(false, true)) {
            acquired = true;
            try {
                Thread thread = Thread.currentThread();
                for (;;) {
                    final Runnable task = tasks.poll();
                    // if the task is null we should exit the loop
                    if (task == null) {
                        break;
                    }

                    boolean ran = false;
                    beforeExecute(thread, task);
                    try {
                        task.run();
                        ran = true;
                        onAfterExecute(task, null);
                    } catch (RuntimeException e) {
                        if (!ran) {
                            onAfterExecute(task, e);
                        }
                        throw e;
                    }
                }
                //TODO  NOTE (I added): between here and "isRunning.set(false)",some new tasks maybe added.
            } finally {
                // set it back to not running
                isRunning.set(false);
            }
        }

        //TODO NOTE (I added): Do the remaining works.
        if (acquired && !isRunning.get() && tasks.peek() != null) {
            doUnorderedExecute(this);
        }
    }
}