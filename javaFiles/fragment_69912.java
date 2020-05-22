package de.scrum_master.app;

public class Application {
  public void doSomething() {
    new Foo().methodA(11, 22);
  }

  public static void main(String[] args) {
    new Application().doSomething();
    new DummyTest().testSomething();
  }
}