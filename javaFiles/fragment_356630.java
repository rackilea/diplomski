class YourExecutor {
  // Initialize in ctor.
  private final ExecutorService executor;

  FromRunnable submit(Runnable r) {
    return new FromRunnable(executor.submit(r));
  }

  <T> FromCallable<T> submit(Callable<? extends T> c) {
  return new FromCallable<>(executor.submit(c));
  }
}