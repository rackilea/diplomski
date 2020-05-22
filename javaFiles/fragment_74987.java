for(int i=0; i<iterations; i++) {
  while (!AtomicBooleanTest.atomic.compareAndSet(false, true));
  int oldValue = AtomicBooleanTest.globalCounter;
  Thread.sleep(1);
  AtomicBooleanTest.globalCounter = oldValue + 1;
  AtomicBooleanTest.atomic.set(false);
}