ReferenceEntry<K, V> getNextEvictable() {
  for (ReferenceEntry<K, V> e : accessQueue) {
    int weight = e.getValueReference().getWeight();
    if (weight > 0) {
      return e;
    }
  }
  throw new AssertionError();
}