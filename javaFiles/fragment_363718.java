RMapCache<String, String> mapCache = redisson.getMapCache("myMap");
int expireListener = map.addListener(new EntryExpiredListener<Integer, Integer>() {
    @Override
    public void onExpired(EntryEvent<String, String> event) {
      event.getKey(); // expired key
      event.getValue() // expired value
      // ...
    }
});

map.put("key", "value", 10, TimeUnit.SECONDS);