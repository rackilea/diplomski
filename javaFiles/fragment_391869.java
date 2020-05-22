final ConcurrentLinkedQueue<T> queue;
final AtomicInteger wip;
@Override public void accept(T t) {
  if(wip.compareAndSet(0, 1)) { // no contention?
    actual.accept(t);
    if(wip.decrementAndGet()==0) return; // still no contention
  }
  else {
    if(!queue.offer(t))
      throw new AssertionError("queue should be unbounded");
    if(wip.getAndIncrement() != 0) return; // other consumer running
  }
  do {
    actual.accept(queue.poll());
  } while (wip.decrementAndGet() > 0);
}