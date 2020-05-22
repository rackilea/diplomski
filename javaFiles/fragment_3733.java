package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

  @RequestMapping(method = RequestMethod.GET, path = "/hello")
  public String hello() {
    System.out.println("called here");
    return "home";
  }
}