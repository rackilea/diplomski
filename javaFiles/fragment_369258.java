public class UnMarshallingTest {

    public static void main(String[] args) throws Exception {
        DefaultCamelContext context = new DefaultCamelContext();
        // append the routes to the context
        context.addRoutes(new UnMarshallingTestRoute());

        //CSVToPerson csvToPerson = new CSVToPerson();
        //SimpleRegistry reg = new SimpleRegistry();
        //reg.put("csvToPerson", csvToPerson);
        //context.setRegistry(reg);

        context.start();

        ConsumerTemplate ct = context.createConsumerTemplate();

        List data = (List<Person>)ct.receiveBody("seda:foo", 5000);

        System.out.println("=================================");
        System.out.println("Return Value::::" + data);
        System.out.println("=================================");

        Thread.sleep(3000);

        context.stop();

    }
}

public class UnMarshallingTestRoute extends RouteBuilder {


    public void configure() throws Exception {
        from("file:/home/viral/Projects/camel/cxfJavaTest/src/data?noop=true")
          .split(body().tokenize("\n")).streaming()
            .unmarshal().csv()
            .bean(CSVToPerson.class).to ("seda:foo") ;
    }
}