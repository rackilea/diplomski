public V put(K key, V value) {
    if (key == null)
        return putForNullKey(value);

    // ... here comes the put code for non-null-keys
}