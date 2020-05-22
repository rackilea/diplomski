ScheduledFuture<Integer> future =
        scheduler.schedule(new ScheduledPrinter(), 10, TimeUnit.SECONDS);
scheduler.schedule(() -> {
    if (!future.isDone()) {
        future.cancel(true);  // cancel task if it runs more than 5 minutes
    }
}, 5, TimeUnit.MINUTES);