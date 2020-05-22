package de.scrum_master.stackoverflow.q56652868;

public class A {
  private B b;
  private C c;
  private D d;
  private E e;

  public A(B b, C c, D d, E e) {
    this.b = b;
    this.c = c;
    this.d = d;
    this.e = e;
  }

  protected void doSth() {
    test();
  }

  protected void test() {
    System.out.println("test");
  }

  public static class B {}
  public static class C {}
  public static class D {}
  public static class E {}
}