Future<?> future = executor.submit(new MyCallable());

try {
  future.get();  // Blocks until the Callable completes.
} catch (ExecutionException e) {
  // You reach here if an exception is thrown in the Callable -
  // The exception is accessible via e.getCause().
}