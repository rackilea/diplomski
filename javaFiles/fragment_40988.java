@WebService (...)
@HandlerChain(file="jaxws-handlers.xml")
public class TestServiceImpl implements TestService {
   public String sayHello(String name) {
      return "Hello " + name + "!";
   }
}