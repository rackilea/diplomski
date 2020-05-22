public class SampleTwo {


public static void main(String[] args) throws Exception {
    final CamelContext camelContext = new DefaultCamelContext();
    camelContext.start();
    camelContext.addRoutes(new RouteBuilder() {

        @Override
        public void configure() throws Exception {          
            from("file://target/inbox?noop=true&fileName=test.csv").to("direct://start"); 
            from("direct://start").to("file://target/outbox");  //ADDED

        }
    });

    Thread.sleep(1000*6000);
}}