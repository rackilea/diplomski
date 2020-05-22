ScheduledFuture<?> future = timer.scheduleAtFixedRate(r, 0, 100, TimeUnit.MILLISECONDS);
try {
    future.get();
} catch (ExecutionException e) {
    Throwable cause = e.getCause();
    cause.printStackTrace();
}