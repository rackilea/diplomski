Runnable foo() {
  final int x = 42;
  return new Runnable() {
    void run() {
      System.out.writeln(x);
    }
  };
}