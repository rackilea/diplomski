AtomicLong value = map.get(key);

if (value == null) {
    value = map.putIfAbsent(key, new AtomicLong(0));
}

long updatedValue = value.incrementAndGet();