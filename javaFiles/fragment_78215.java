public Object atomicGetAndDelete(MemcacheService memcache, int key) {
    assert key>=0;
    if (memcache.increment(-key-1, 1L, 0L) != 1L) return null; // Are we 1st?
    Object result = memcache.get(key);                         // Grab content
    memcache.delete(key);                                      // Delete entry
    return result;
}