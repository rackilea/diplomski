private Integer somefunction() {
    Integer oldOrder;
    // Insert key if it isn't already present.
    oldOrder = count.putIfAbsent(key, 1);
    if (oldOrder == null) {
        return 0;
    }
    // If we get here, oldOrder holds the previous value.
    // Atomically update it.
    while (!count.replace(key, oldOrder, oldOrder + 1)) {
        oldOrder = count.get(key);
    }
    return oldOrder;
}