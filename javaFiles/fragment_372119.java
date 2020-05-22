String key = "key";
Integer cached = 0;

MemcacheService memcacheService = MemcacheServiceFactory.getMemcacheService();
memcacheService.setErrorHandler(new StrictErrorHandler());
cached = (Integer) memcacheService.get(key);
if (cached == null) {
  memcacheService.put(key, 0);
} else {
  memcacheService.put(key, cached + 1);
}