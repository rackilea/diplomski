class Test {
  class C<T extends C<T>> {}
  void m() {
    C<?> i = new C<>();
  }
}