package com.foo.some-package;

public class SomeClass {

  public void init() {
      MyApplication.addCss(this.getClass().getResource("base.css").toString());
  }
}