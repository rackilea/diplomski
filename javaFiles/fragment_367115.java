private int expire = 2;

 public <T> void insert(Supplier<T> supplier, String... keyLine) throws InterruptedException, MemcachedException, TimeoutException {
        String key = ParseUtils.collectToKeyWithDot(keyLine);
        T value = getCache(key);
        if (value == null) {
            value = supplier.get();
            setCache(key, value);
        } 
    }

 private <T> Boolean setCache(String key, T value) throws InterruptedException, MemcachedException, TimeoutException {
        return memcacheClient.set(key, expire, value);
    }

    private <T> T getCache(String key) throws InterruptedException, MemcachedException, TimeoutException {
        return memcacheClient.get(key);
    }