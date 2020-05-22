ListenableFuture<Integer> future = MoreExecutors.listeningDecorator(executor).submit(
  new Callable<Integer>() {
    @Override
    public Integer call() throws Exception {
      ...
    }
});

// Add jobId to the map. You should use a thread-safe Map!
map.put(jobId, future);

Futures.addCallback(future, new FutureCallback<Integer>(){
  @Override
  public void onSuccess(Integer result) {
    map.remove(jobId);
    ...
  }

  @Override
  public void onFailure(Throwable t) {
    map.remove(jobId);
    ...
  }});