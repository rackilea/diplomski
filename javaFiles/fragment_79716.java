interface Foo {
  default int Dumb() {
    return 2*getArgument();
  }
  int getArgument();
}

class A implements Foo {
  int argument = 42;

  public int getArgument() {
    return argument;
  }

  public static void main(String[] args) {
    A a = new A();
    System.out.println(a.Dumb());
  }
}