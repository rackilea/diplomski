public Object atomicGetAndDelete(MemcacheService memcache, Object key) {
    IdentifiableValue result = memcache.getIdentifiable(key);
    if (result==null) return null;                     // Entry didn't exist
    if (result.getValue()==null) return null;          // Someone else got it
    if (!memcache.putIfUntouched(key, result, null)) return null;  // Still 1st?
    memcache.delete(key);                              // Delete entry
    return result.getValue();
}