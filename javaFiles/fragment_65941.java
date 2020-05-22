public void start() {
  runOneIteration();
  startAsync();
}

@Override
protected Scheduler scheduler() {
    return Scheduler.newFixedRateSchedule(0, 10, TimeUnit.SECONDS);
}