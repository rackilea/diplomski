package de.scrum_master.app;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@LooseController
@RequestMapping("/something")
public class Controller1 extends PutController {
  public static void main(String[] args) {
    new Controller1().update("foo");
  }
}