package com.controller.ccc;

import com.dao.ddd.MyDao;

public class MyController {
  public void doSomething() {
    System.out.println("Doing something in controller");
    new MyDao().doSomething();
  }
}