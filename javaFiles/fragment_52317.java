class Three {
  public Three() {
    this(1);
  }

  public Three(int a) {
    this(a, 2);
  }

  public Three(int a, int b) {
    this(a, b, 3);
  }

  public Three(int a, int b, int c) {  }

  // can pass any number of `int` values.
  public void method1(int... varargs) {
  }

  public void method2(int a) {
     method2(a, 2);
  }

  public void method2(int a, int b) { }
}