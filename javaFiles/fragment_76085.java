public Map<String, String> parseMap(String mapString) {
  if (mapString == null || mapString.isEmpty()) {
    return Collections.emptyMap();
  }
  return Arrays.stream(mapString.split("&"))
    .map(this::splitParam)
    .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
}

public AbstractMap.SimpleEntry<String, String> splitParam(String it) {
  final int idx = it.indexOf("=");
  final String key = it.substring(0, idx);
  final String value = it.substring(idx + 1);
  return new AbstractMap.SimpleEntry<>(key, value);
}