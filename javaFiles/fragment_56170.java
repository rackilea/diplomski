AtomicInteger seed = new AtomicInteger((int) System.nanoTime());

  public int nextUniqueNegativeNumber() {
    int oldVal, n;
    do {
      do {
        oldVal = seed.get();
        n = oldVal ^ (oldVal << 13); // Added correction
        n ^= (n >>> 17);
        n ^= (n << 5);
      } while (seed.getAndSet(n) != oldVal);
    } while (n > 0);
    return n;
  }