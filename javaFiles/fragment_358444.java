CompletableFuture<Void> f = xyz.someMethod();
f.handleAsync((v, th) -> { 

  if (th == null) {
    future.complete(null);
  } else {
    future.completeExceptionally(th);
  }

  return null;
}, vertx.nettyEventLoopGroup());