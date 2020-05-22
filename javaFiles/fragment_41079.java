public class Testing {
  static interface A<F, S> {
    public F getF();
    public S getS();
  }

  static <V, S> Comparator<A<V, S>> wrap(Comparator<S> c) {
    return (L, R) -> c.compare(L.getS(), R.getS());
  }

  public static void main(String[] args) {
    Comparator<A<String, Integer>> comp = Testing.<String, Integer>wrap((L, R) -> Integer.compare(L, R))
      .thenComparing(wrap((L, R) -> Integer.compare(L, R)));
  }
}