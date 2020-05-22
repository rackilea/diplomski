public Object atomicGetAndDelete(MemcacheService memcache, int key) {
    assert key>=0;
    if (!memcache.put(-key-1, null, null, SetPolicy.ADD_ONLY_IF_NOT_PRESENT))
        return null;                    // Are we 1st?
    Object result = memcache.get(key);  // Grab content
    memcache.delete(key);               // Delete entry
    memcache.delete(-key-1, 10000);     // Delete marker with millisNoReAdd
    return result;
}