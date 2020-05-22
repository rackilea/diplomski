class Pair<T> {
  T var;

  Pair() {}

  Pair(Class<T> reflection) {
    var = reflection.newInstance();
  }

  void func() {
    System.out.println(var);
  }
}