private Future lastTask = null;

// only run one task at a time.
if (lastTask != null) lastTask.cancel(true);

lastTask = executorService.submit(new ProcessOnRowRunnable());
// or
lastTask = executorService.submit(new ProcessPendingRowsAndStopRunnable());
// or
lastTask = executorService.submit(new ProcessAllRowsUntilCancelledRunnable())

// later
future.cancel(true);