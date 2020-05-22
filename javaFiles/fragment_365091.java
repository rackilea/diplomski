//get reference to the future
Future<?> future = service.scheduleAtFixedRate(runnable, INITIAL_DELAY, INTERVAL, TimeUnit.SECONDS)
//cancel instead of shutdown
future.cancel(true);
//schedule again (reuse)
future = service.scheduleAtFixedRate(runnable, INITIAL_DELAY, INTERVAL, TimeUnit.SECONDS)
//shutdown when you don't need to reuse the service anymore
service.shutdown()