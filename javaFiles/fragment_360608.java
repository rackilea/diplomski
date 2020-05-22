private void test() {
  System.out.println(hello(new A()));
  System.out.println(hello(new B()));
  System.out.println(hello(new C()));
  System.out.println(hello(new D()));
}

public String hello(A a) {
  return a.hello();
}