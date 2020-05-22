static AtomicInteger counter = new AtomicInteger();

// ...

while (true) {
  counter.getAndIncrement();
}