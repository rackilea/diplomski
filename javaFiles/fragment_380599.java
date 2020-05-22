Map<Set<String>, String> somemap = new HashMap<Set<String>, String>();
foreach(Map.entry entry : existingMap.entrySet()) {
  Set<String> value = entry.getValue();
  String key = entry.getKey();
  somemap.put(value,key);

}