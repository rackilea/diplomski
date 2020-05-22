Map<String, String> map = /* ... */;
Iterator<String> iterator = map.keySet().iterator();
while (iterator.hasNext()) {
  String key = iterator.next();
  if (key.equals("Test")) {
    iterator.remove();
  }
}