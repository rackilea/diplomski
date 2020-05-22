interface A {
  void foo() throws IOException;
}

interface B extends A {
  void foo();
}

A a = new B() { ... }
try {
    a.foo();
} catch (IOException e) {
    // must catch even though B.foo() won't throw one
}