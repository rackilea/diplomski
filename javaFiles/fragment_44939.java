final Runnable stopTask = new Runnable() {
    @Override
    public void run() {
        futureHandle.cancel(true); // true: interrupt if necessary
    }
};
long delay = // some number, how long to wait before invoking the stop task
scheduler.schedule(stopTask, delay, TimeUnit.SECONDS).get(); // wait if necessary and get the future result
scheduler.shutdown(); // shutdown on completion