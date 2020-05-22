private final ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
private final ReentrantLock lock = new ReentrantLock();

public Object getSomeObject(String key) {
    Object value = map.get(key);
    if (value == null) {
        try {
            lock.lock();
            value = map.get(key);
            if (value == null) {
                value = retrieveSomeObjectFromService(key);
                map.put(key, value);
            }

        } finally {
            lock.unlock();
        }

    }
    return value;
}