public static <T extends Number> T firstNonZero(T... values) {
    T zero = null;
    for (T value : values) {
      if (value.doubleValue() != 0.0) {
        return value;
      } else {
        zero = value;
      }
    }
    return zero;
  }