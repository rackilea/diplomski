public static <T1, T2, T3, R> Function<T1, R> applyIfNotNull(Function<T1, T2> mapper1, Function<T2, T3> mapper2,
    Function<T3, R> mapper3) {
  return t -> {
    if (t == null) {
      return null;
    } else {
      T2 t2 = mapper1.apply(t);
      if (t2 == null) {
        return null;
      } else {
        T3 t3 = mapper2.apply(t2);
        return t3 == null ? null : mapper3.apply(t3);
      }
    }
  };
}