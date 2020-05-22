package de.scrum_master.app;

@Trace
public class SomeClass {
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
}