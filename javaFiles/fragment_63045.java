...
    final List<ProgressRunnable> tasks = new ArrayList<ProgressRunnable>();
    tasks.add(new ProgressRunnable<Object>() {
        @Override
        public Object run(ProgressHandle ph) {
            ph.progress("Work unit 1", 1);
            return null;
        }
    });
    tasks.add(new CancellableTask());
    ProgressUtils.showProgressDialogAndRun(new ProgressRunnable<Void>() {
        @Override
        public Void run(ProgressHandle ph) {
            // run all tasks passing in the ProgressHandle to each
            for (ProgressRunnable task : tasks) {
                task.run(ph);
            }
            return null;
        }
    }, "Running Startup", true);
    ...
    // will show a Cancel button on the progress UI
    private class CancellableTask implements ProgressRunnable<Object>, Cancellable {

    @Override
    public Object run(ProgressHandle ph) {
        ph.progress("Cancellable work unit", 2);
        return null;
    }

    @Override
    public boolean cancel() {
        // clean up 
        return true;
    }
}