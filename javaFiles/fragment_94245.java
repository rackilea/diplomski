new Properties() {
    @Override
    public synchronized Object put(Object key, Object value) {
        if (get(key) != null) {
            throw new IllegalArgumentException(key + " already present.");
        }
        return super.put(key, value);
    }
}.load(...);