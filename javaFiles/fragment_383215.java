@WebMethod(operationName = "hello")
public String hello() {
  try {
    return "Hello World";
  } catch(Exception e) {
    // Throw the fault here.
  }
}