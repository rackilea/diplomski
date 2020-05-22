private static Map<String, String> decodeMap(
    Map<String, String> encodedData,
    Map<String, Transformation> transformations) {
  Map<String, String> decodedData = new HashMap<>();
  for (Entry<String, String> e : encodedData.entrySet()) {
    Transformation t = transformations.get(e.getKey());
    if (t == null) {
      t = Transformation.NO_OP; // just passes the entry through
    }
    Entry<String, String> decoded = t.apply(e);
    decodedData.put(decoded.getKey(), decoded.getValue());
  }
  return decodedData;
}