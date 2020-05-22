AtomicBoolean isRefreshing = new AtomicBoolean(false);

void refresh() {
  if ( isRefreshing.compareAndSet( false, true)) {
    try {
      // refresh
    } finally {
      isRefreshing.set( false);
    }
  }
}