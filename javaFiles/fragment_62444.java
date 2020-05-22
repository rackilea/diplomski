class MyCallable implements Callable<Void> {
  @Override public Void call() throws Exception {
    // Do something - you don't need to catch Exception as Callable throws it.
    // ...

    return null;  // A return is necessary from a Callable.
  }
}