Runnable listener = new Runnable() {
    private boolean jobDone = false;

    @Override
    public synchronized void run() {
        if (jobDone || !(future1.isDone() && future2.isDone())) {
            return;
        }
        jobDone = true;
        // TODO do your job
    }
};
future1.addListener(listener);
future2.addListener(listener);