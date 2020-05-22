class MyWrapperExecutor extends ForwardingListeningExecutorService {
  private final ExecutorService delegateExecutor;

  @Override public <T> ListenableFuture<T> submit(Callable<T> task) {
    if (callable instanceof SomeClass) {
      // Modify and submit Callable (or just submit the original Callable):
      ListenableFuture<T> delegateFuture =
          delegateExecutor.submit(new MyCallable(callable));
      // Modify Future:
      return new MyWrapperFuture<T>(delegateFuture);
    } else {
      return delegateExecutor.submit(callable);
    }
  }

  // etc.
}