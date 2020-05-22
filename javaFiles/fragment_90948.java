private static Map<String, String> decodeMap(
    Map<String, String> encodedData,
    Map<String, Transformation> transformations,
    Map<String, List<String>> duplications) {
  // ... existing method body
  for (Entry<String, List<String>> e : duplications) {
    String value = checkNotNull(decodedData.get(e.getKey()));
    for (String newKey : e.getValue()) {
      decodedData.put(newKey, value);
    }
  }
  return decodedData;
}