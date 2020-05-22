// Create cache
final int MAX_ENTRIES = 100;
Map cache = new LinkedHashMap(MAX_ENTRIES+1, .75F, true) {
    // This method is called just after a new entry has been added
    public boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
};

// Add to cache
Object key = "key";
cache.put(key, object);

// Get object
Object o = cache.get(key);
if (o == null && !cache.containsKey(key)) {
    // Object not in cache. If null is not a possible value in the cache,
    // the call to cache.contains(key) is not needed
}

// If the cache is to be used by multiple threads,
// the cache must be wrapped with code to synchronize the methods
cache = (Map)Collections.synchronizedMap(cache);