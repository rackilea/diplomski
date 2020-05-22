private Map<String, Object> someMap1 = new ConcurrentHashMap<String, Object>();
    private Map<String, Object> someMap2 = new ConcurrentHashMap<String, Object>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Object getDataFromMap(String key) {
        r.lock();
        try {
            // do some logic here and return data from map
            return someObj;
        } finally {
            r.unlock();
        }
    }

    public void reloadData() {
        w.lock();
        try {
            someMap1.clear();
            someMap2.clear();
            // read new data here and re-fill the maps
        } finally {
            w.unlock();
        }
    }