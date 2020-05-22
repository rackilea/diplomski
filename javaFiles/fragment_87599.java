package helloservice.endpoint;

import javax.jws.WebService;

@WebService()
public class Hello {
  private String message = new String("Hello, ");

  public void Hello() {}

  public String sayHello(String name) {
    return message + name + ".";
  }
}