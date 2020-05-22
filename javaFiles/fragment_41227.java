public static <T, U> Function<T, U> applyIfNotNull(Function<T, U> mapper) {
  return t -> t != null ? mapper.apply(t) : null;
}

public static <T, U> Function<T, U> applyIfNotNullOrDefault(Function<T, U> mapper, U defaultValue) {
  return t -> t != null ? mapper.apply(t) : defaultValue;
}

public static <T, U> Function<T, U> applyIfNotNullOrElseGet(Function<T, U> mapper, Supplier<U> supplier) {
  return t -> t != null ? mapper.apply(t) : supplier.get();
}