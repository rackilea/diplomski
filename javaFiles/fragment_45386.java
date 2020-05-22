package com.service.sss;

import com.dao.ddd.MyDao;

public class MyService {
  public void doSomething() {
    System.out.println("Doing something in service");
    new MyDao().doSomething();
  }
}