class Test {
  <T> T and(T a, T b) { return null; }
  class C<T> {}

  void g(String s) {}
  void g(Object s) {}

  void m() {
    g(
        and(
        and(
        and(
        and(
        and(
        and(
        and(new C<>(),
            new C<>()),
            new C<>()),
            new C<>()),
            new C<>()),
            new C<>()),
            new C<>()),
            new C<>()));
  }
}