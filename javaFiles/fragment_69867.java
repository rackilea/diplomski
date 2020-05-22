package de.scrum_master.app;

public class B {
  public void bar() {
    A a = new A();
    a.foo(() -> new MyCustomClass());
  }

  public static void main(String[] args) {
    new B().bar();
  }
}