public static <K, V extends Number> Number printValues(Pair<K, V> p1, Pair<K, V> p2) {
  if(p1.getValue() instanceof Double || p2.getValue() instanceof Double) {
    return new Double(p1.getValue().doubleValue() + p2.getValue().doubleValue());
  } else if(p1.getValue() instanceof Float || p2.getValue() instanceof Float) {
    return new Float(p1.getValue().floatValue() + p2.getValue().floatValue());
  } else if(p1.getValue() instanceof Long || p2.getValue() instanceof Long) {
    return new Long(p1.getValue().longValue() + p2.getValue().longValue());
  } else {
    return new Integer(p1.getValue().intValue() + p2.getValue().intValue());
  }
}