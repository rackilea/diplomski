package com.company.app;

public class Application {
  public static void main(String[] args) {
    new Application().doSomething(new MyClass(), 11);
  }

  public String doSomething(MyClass myClass, int i) {
    return "blah";
  }
}