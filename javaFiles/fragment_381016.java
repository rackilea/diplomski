CancellableContext withCancellation = Context.current().withCancellation();
Context prevCtx = withCancellation.attach();
try {
  stub.foo(request, responseObserver);
} finally {
  withCancellation.detach(prevCtx);
}