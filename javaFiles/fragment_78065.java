private Map<String, Object> flatten(Map<String, Object> in) {
    return in.entrySet().stream()
        .flatMap(entry -> flatten(entry).entrySet().stream())
        .collect(Collectors.toMap( 
               Map.Entry::getKey, 
               Map.Entry::getValue));
}

private Map<String, Object> flatten(Map.Entry<String, Object> in) {
  // for other then Map objects return them
  if (!Map.class.isInstance(in.getValue())) {
    return Collections.singletonMap(in.getKey(), in.getValue());
  }
  // extract the key prefix for nested objects
  String prefix = in.getKey();
  Map<String, Object> values = (Map<String, Object>) in.getValue();
  // create a new Map, with prefix added to each key
  Map<String, Object> flattenMap = new HashMap<>();
  values.keySet().forEach(key -> {
    // use a dot as a joining char
    flattenMap.put(prefix + "." + key, values.get(key));
  });
  // use recursion to flatten the structure deeper
  return flatten(flattenMap);
}