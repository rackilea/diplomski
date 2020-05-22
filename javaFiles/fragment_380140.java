Redisson redisson = …

RMap map = redisson.getMap("my-map"); // implement java.util.Map

map.put("key", "value");

map.containsKey("key");

map.get("key");