public class MyAssembler {
    public void assemble(Exchange exchange) {
      String content = exchange.getIn().getHeader("content", String.class);
      // Create MyObject here.
      MyObject object; // ...transformation here.
      exchange.getOut().setBody(object);
   }
}