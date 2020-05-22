class Counter {
  private int x;

  public synchronized int count() {
    if (x == Integer.MAX_VALUE) { throw new IllegalStateException(); }
    return x++;
  }
}