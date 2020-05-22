public void notify(String key) {
    AtomicLong value = stats.get(key);
    if (value == null) {
        value = stats.putIfAbsent(key, new AtomicLong(1));
    }
    if (value != null) {
        value.incrementAndGet();
    }
}