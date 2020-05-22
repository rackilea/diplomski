for (String cacheName : getCacheManager().getCacheNames()) {
logger.info("Clearing cache: " + cacheName);
Cache cache = getCacheManager().getCache(cacheName);
Object obj = cache.getNativeCache();
if (obj instanceof net.sf.ehcache.Ehcache) {
Ehcache ehCa = (Ehcache)obj;
List<Object> keys = ehCa.getKeys();

for (Object key : keys) {
    String keyString = (String)key;
    if (keyString.equalsIgnoreCase("CACHE_LIST_COLUMNS_10000_2")) 
        {
       cache.evict(key);
    }
 }
}
}