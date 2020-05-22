// Initialize in ctor use MoreExecutors
private final ListeningExecutorService service;

// Keep to call .cancel()
private ListenableFuture<APIData> currentRequest;

// Run in the GUI thread
public void onRefreshEvent() {
  showProgressIndicator();
  currentRequest = service.submit(/* Some Callable<APIData> */);
  Futures.addCallback(currentRequest , this, this);
}

// From FutureCallback<T>
public void onFailure(Throwable t) {} // TODO
public void onSuccess(APIData d) {}   // TODO

// From Executor
public void execute(Runnable cmd) {
  Platform.runLater(cmd);
}