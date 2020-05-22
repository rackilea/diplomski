ExecutorService executor = Executors.newSingleThreadScheduledExecutor();

// Schedule your audio processing job like normal.
final Future<?> future = executor.submit(new MyAudioProcessingRunnable())

// Schedule the cancelation to happen in 20 seconds.
executor.schedule(new Runnable() {
  if (!future.isCancelled() && !future.isDone()) {
    // Cancel and interrupt any blocking calls.
    future.cancel(true);
  }
}, 20, TimeUnit.Seconds);