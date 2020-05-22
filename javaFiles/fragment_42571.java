public void AddToCache(T key, V value) {
    for (;;) {

        V local = _cache.get(key);
        if(local == null){
            local = _cache.putIfAbsent(key, value);
            if(local == null)
                return;
        }
        if (local.equals(value) && !local.IsExpired()) {
            return;
        }

        if (_cache.replace(key, local, value))
            return;
    }
}