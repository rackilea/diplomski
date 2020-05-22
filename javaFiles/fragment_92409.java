// In a Route Builder somewhere.
from("servlet:///myService")
    .setHeader(ConditionalProcessor.PROPERTY, constant(true))
    .inOut("direct:myService");
from("direct:myService").process(new ConditionalProcessor());

// Implementation of processor above.
public class ConditionalProcessor implements Processor {
    public static final String PROPERTY = "came.from.servlet";
    @Override
    public void process(Exchange exchange) throws Exception {
        if(comesFromServlet(exchange)){
            // Logic for Servlet.
        } else {
            // Logic for direct and other.
        }
    }

    public boolean comesFromServlet(Exchange exchange){
        return exchange.getProperty(PROPERTY, true, Boolean.class);
    }

}