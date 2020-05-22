Map<String, String> map = /* ... */;
Map<String, String> mapToPut = new HashMap<>();
Iterator<String> iterator = map.keySet().iterator();
while (iterator.hasNext()) {
  String key = iterator.next();
  if (key.equals("Test")) {
    mapToPut.put("New key for " + key, "new value");
  }
}
map.putAll(mapToPut);