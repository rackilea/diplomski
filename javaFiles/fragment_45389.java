package de.scrum_master.app;

import com.controller.ccc.MyController;
import com.service.sss.MyService;

public class Application {
  public static void main(String[] args) {
    // Allowed
    new MyService().doSomething();
    // Forbidden
    new MyController().doSomething();
  }
}