@Scheduled(cron = "0 0 * * * ?")
public void executeStrangely() {
    // Based on the schedule above,
    // all schedule finalization should happen at minute 0.
    // If the pool tries to execute at minute 0, there *might* be
    // a race condition with the actual thread running this block.
    // We do *not* include minute 0 for this reason.
    Random random = new Random();
    final int actualMinuteOfExecution = 1 + random.nextInt(59);
    final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

    exec.schedule(() -> {
        // Critical code here
    }, actualMinuteOfExecution, TimeUnit.MINUTES);
}