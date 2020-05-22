class EndSessionTask {

    final long sessionExpirationTime;
    volatile ScheduledFuture future;

    public EndSessionTask(long ts) { sessionExpirationTime = ts; }

    public void run() {
        if (sessionExpirationTime < currentTs) return;
        endSession();
        future.cancel();
    }

    public void setFuture(ScheduledFuture f) { this.future = f; }
}

long endSessionTime = System.currentTimeMillis() + 6 * 60 * 1000;
EndSessionTask task = new EndSessionTask(endSessionTime);
ScheduledFuture future = executorService.scheduleAtFixedRate(task, 10L, 10L, SECONDS);
task.setFuture(future);