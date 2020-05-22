package com.foo.test;

public class Foo implements FooMBean {
  private String name;

  ...

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void printName() {
    System.out.println(name);
  }
}