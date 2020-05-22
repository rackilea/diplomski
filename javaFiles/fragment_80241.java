package de.scrum_master.app;

public class Application {
  public void doSomething() {
    foo();
    bar();
    zot();
  }

  @Trace
  public void foo() {}

  public void bar() {}

  @Trace
  public void zot() {}

  public static void main(String[] args) {
    new Application().doSomething();
    new SomeClass().doSomething();
  }
}