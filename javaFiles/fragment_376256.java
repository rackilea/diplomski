private static long longValue(Object value) {
    return (value instanceof Number ? ((Number)value).longValue() : -1);
  }

  private static double doubleValue(Object value) {
    return (value instanceof Number ? ((Number)value).doubleValue() : -1.0);
  }