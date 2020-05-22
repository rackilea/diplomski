private static <T, U> U convertBy(T arg, Function<T, U> func1) {
  return func1.apply(arg);
}

private static <T, U, V> V convertBy(T arg, Function<T, U> func1, Function<U, V> func2) {
  return func2.apply(func1.apply(arg));
}

private static <T, U, V, X> X convertBy(T arg, Function<T, U> func1, Function<U, V> func2, Function<V, X> func3) {
  return func3.apply(func2.apply(func1.apply(arg)));
}