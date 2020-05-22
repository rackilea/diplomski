public MyHashMap(K[] keys, V[] values) {
    super();

    if (keys.length != values.length) {
        throw new IllegalArgumentException("Array lengths are not equivalent!");
    }
    // Store the <key,value> pairs to the HashMap object
    for (int i = 0; i < keys.length; i++) {
        put(keys[i], values[i]);
    }
}