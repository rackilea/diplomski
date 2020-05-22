for (;;) {
  if (counter.decrementAndGet() <= 0) {
    // TODO: exit the app
  }
  Thread.sleep(1000);
}