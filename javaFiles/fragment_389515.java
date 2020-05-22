public class A {
  int ai;

  public A() {
    super();
    ai = 5;
    foo();
  }

  public void foo() {
    System.out.println(ai);
  }
}

class B extends A {
  int bi;

  public B() {
    super();
    bi = 6;
  }
}

class C extends B {
  int ci;

  public C() {
    super();
    ci = 7;
  }

  public void foo() {
    System.out.print(bi);
  }

  public static void main(String[] args) {
    C c = new C();
  }
}