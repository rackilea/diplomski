public static String getValue(Map<String, Map<String, String>> mapOfMaps, String mapfind, String val) {
    Map<String, String> innerMap = mapOfMaps.get(mapfind);
    return innerMap != null ?
      innerMap.get(val) :
      null;
  }