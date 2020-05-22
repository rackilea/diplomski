Task<Void> task = new Task<Void>() {
    @Override
    protected Void call() throws Exception {
        // makes the long-running API call
        return null;
    }
};
task.setOnRunning((WorkerStateEvent event) -> {
    // disable ui
});

task.setOnCancelled((WorkerStateEvent event) -> {
    // reenable ui
    // handle cancel
});
task.setOnSucceeded((WorkerStateEvent event) -> {
    // reenable ui
    // handle succeed
});

task.setOnFailed((WorkerStateEvent event) -> {
    // reenable ui
    // handle failed task e.g.:
    System.err.println("Oops, Error:");
    task.getException().printStackTrace(System.err);
});

Thread t = new Thread(task);
// thread shouldn't prevent program shutdown
t.setDaemon(true);
t.start();