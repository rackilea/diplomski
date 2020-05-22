public void insertOrReplace(String key, String value) {
    for (;;) {
        String oldValue = concurrentMap.putIfAbsent(key, value);
        if (oldValue == null)
            return;

        final String newValue = recalculateNewValue(oldValue, value);
        if (concurrentMap.replace(key, oldValue, newValue))
            return;
    }
}