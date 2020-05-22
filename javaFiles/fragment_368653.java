<T> ScheduledFuture<?> thenReturnMockFuture(
    OngoingStubbing<ScheduledFuture<T>> stubbing) {
  // Declare a local abstract class, so that future is type-correct.
  abstract class ScheduledFutureT implements ScheduledFuture<T> {}
  ScheduledFuture<T> future = mock(ScheduledFutureT.class);

  stubbing.thenReturn(future);
  return future;
}