import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.BasicConfigurator;

import javax.jms.ConnectionFactory;

public class CurrencyRoute {

    public static void main(String args[]) throws Exception {
        // Log 4j
        BasicConfigurator.configure();

        // Create camel context
        CamelContext context = new DefaultCamelContext();

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        context.addComponent("test-jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        // New route
        context.addRoutes(new RouteBuilder() {
            public void configure() {

                from("quartz://myTimer?trigger.repeatCount=0")
                        .log("### Quartz trigger ###")
                        .to("direct:readFile");

                from("direct:readFile")
                        .log("### HTTP to XML ###")
                        .to("https://www.dnb.no/portalfront/datafiles/miscellaneous/csv/kursliste_ws.xml")
                        .to("test-jms:queue:currency");
            }
        });

        // start the route and let it do its work
        context.start();
        Thread.sleep(10000);

        // stop the CamelContext
        context.stop();


    }
}