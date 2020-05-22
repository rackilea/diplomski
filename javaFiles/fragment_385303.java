AtomicInteger ai = new AtomicInteger(0);

int threadInt = ...

// Update ai atomically, but only if the current value is less than threadInt
ai.updateAndGet(value -> value < threadInt ? threadInt : value);