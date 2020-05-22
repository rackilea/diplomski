public void putForAtomicGnD(MemcacheService memcache, int key, Object value) {
    assert key>=0;
    memcache.put(key, value);    // Put entry
    memcache.put(-key-1, null);  // Put a marker
}

public Object atomicGetAndDelete(MemcacheService memcache, int key) {
    assert key>=0;
    if (!memcache.delete(-key-1)) return null;  // Are we first to request it?
    Object result = memcache.get(key);          // Grab content
    memcache.delete(key);                       // Delete entry
    return result;
}