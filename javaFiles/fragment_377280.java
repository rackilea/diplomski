ConcurrentMap<Key, Long> map = new ConcurrentHashMap<>();

public boolean putIfGreater(Key key, long value) {
    Long boxedValue = Long.valueOf(value);
    Long current = map.putIfAbsent(key, boxedValue);
    if (current == null) {
        return true;
    } else {
        while (true) {
            if (value < current) {
                return false;
            }
            if (map.replace(key, current, boxedValue)) {
                return true;
            }
            current = map.get(key);
        }
    }
}