private static final Map<Object, List<Locker<Object, String>>> CONCURRENT_SEARCHES = new ConcurrentHashMap<>();


public String search(Map<String, Object> params) {
    Object key = params.get("keyword");
    assert key != null;
    Locker<Object, String> locker = new Locker<>(key);
    if (isInProgress(key, locker)) {
        locker.lock();
        String result = locker.getValue();
        return result == null ? "[]" : result;
    }
    String result = /*search*/;
    finished(key, result);
    return result;
}

private static synchronized boolean isInProgress(Object key, Locker<Object, String> locker) {
    List<Locker<Object, String>> list = CONCURRENT_SEARCHES.get(key);
    if (list != null) {
        list.add(locker);
        return true;
    }
    CONCURRENT_SEARCHES.put(key, Collections.synchronizedList(new ArrayList<>()));
    return false;
}

private static synchronized void finished(Object key, String result) {
    Optional.of(CONCURRENT_SEARCHES)
            .map(searches -> searches.remove(key))
            .ifPresent(list -> {
                list.stream().forEach(locker -> {
                    locker.setValue(result);
                    locker.unlock();
                });
                list.clear();
            });
}