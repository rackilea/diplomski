class A {
  B b = new B();
  void do() {
    b.play();
  }
}

class B {
  A a = new A();
  void play() {
    System.out.println(a);
  }
}