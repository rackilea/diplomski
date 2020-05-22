ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

ListenableFuture<A> futureA = service.submit(() -> a.doSomething());

Futures.addCallback(futureA, new FutureCallback<A>() {
    @Override
    public void onSuccess(final A result) {
         ListenableFuture<B> futureB = service.submit(() -> b.doSomething(result);
         Futures.addCallback(futureB, new FutureCallback<B>() {
              ©Override
              public void onSuccess(final B resultB) {
                  //Do something with result and resultB.
              }
         });
    }
});