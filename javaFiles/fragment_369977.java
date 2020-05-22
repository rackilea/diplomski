private final AtomicBoolean isEvenTick = new AtomicBoolean();
...
boolean currentValue;
do {
  currentValue = isEvenTick.get();
} while (!isEvenTick.compareAndSet(currentValue, !currentValue);