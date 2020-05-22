class MyCallable implements Callable<String> {
  @Override
  public String call() {
    // ...
    if(Thread.currentThread().isInterrupted()) {
      throw new InterruptedException();
    }
    return "blah";
  }
}