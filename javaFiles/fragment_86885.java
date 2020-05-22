private final ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();

public Object getSomeObject(String key) {
    Object value = map.get(key);
    if (value == null) {
        synchronized (map) {
            value = map.get(key);
            if (value == null) {
                value = retrieveSomeObjectFromService(key);
                map.put(key, value);
            }
        }
    }
    return value;
}