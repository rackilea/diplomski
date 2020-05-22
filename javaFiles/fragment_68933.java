public V computeIfAbsent(K key,
                         Function<? super K, ? extends V> mappingFunction) {
    Objects.requireNonNull(mappingFunction);
    final V v = get(key);
    if (v == null) {
        final V newValue = mappingFunction.apply(key);
        if (newValue != null) {
            put(key, newValue);
            return newValue;
        }
    }

    return v;
}