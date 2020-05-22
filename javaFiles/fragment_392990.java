class RWDictionary {
    private final Map<String, Data>  m = new TreeMap<String, Data>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Data get(String key) {
        r.lock(); try { return m.get(key); } finally { r.unlock(); }
    }
    public String[] allKeys() {
       r.lock(); try { return m.keySet().toArray(); } finally { r.unlock(); }
    }
    public Data put(String key, Data value) {
        w.lock(); try { return m.put(key, value); } finally { w.unlock(); }
    }
    public void clear() {
        w.lock(); try { m.clear(); } finally { w.unlock(); }
   }
 }