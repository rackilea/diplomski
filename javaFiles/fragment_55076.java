public T get(Object key) {
    if (!(key instanceof String)) {
        return null;
    }
    return super.get(((String) key).toLowerCase());
}