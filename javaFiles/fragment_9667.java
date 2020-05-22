public void bow(Friend bower) {  // Method no longer synchronized.
  int firstHash = System.identityHashCode(this);
  int secondHash = System.identityHashCode(bower);

  Object firstMonitor = firstHash < secondHash ? this : bower;
  Object secondMonitor = firstHash < secondHash ? bower : this;
  synchronized (firstMonitor) {
    synchronized (secondMonitor) {
      // Code free (*) of deadlocks, with respect to this and bower at least.
    }
  }
}