public MyClass(int y) {
  this(y, generateX());
  //some code
}

private MyClass(int y, int x) {
  super(y, x, x);
  //some code
}

private static int generateX() {
  return 10;
}