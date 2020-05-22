interface A {
  void foo();
}

interface B extends A {
  void foo() throws IOException;
}

A a = new B() { ... }
a.foo();