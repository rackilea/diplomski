static ListenableFuture<Boolean> doIoWork() {
  // ...
}

static ListenableFuture<Boolean> doIoWithRetry(
    ListeningExecutorService executor) {
  SettableFuture<Boolean> finalResult = SettableFuture.create();
  calculateStuff();
  doIoWithRetry(executor, finalResult);
  return finalResult;
}

private static void doIoWithRetry(
    final ListeningExecutorService executor,
    final SettableFuture<Boolean> finalResult) {
  final ListenableFuture<Boolean> pendingWork = doIoWork();
  pendingWork.addListener(new Runnable() {
    @Override public void run() {
      // pendingWork is now complete
      // (error checking elided here)
      boolean ioSuccessful = pendingWork.get();
      if (ioSuccessful) {
        finalResult.set(true);
        return;
      }
      doIoWithRetry(executor, finalWork);
    }
  }, executor);
}