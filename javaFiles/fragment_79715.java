interface Foo {
  default int Dumb() {
    return 2*this.argument;
  }
}

class A implements Foo {
  int argument = 42;

  public static void main(String[] args) {
    A a = new A();
    System.out.println(a.Dumb());
  }
}