import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.amqp.AMQPComponent;
import org.apache.camel.main.Main;
import org.apache.qpid.amqp_1_0.jms.impl.ConnectionFactoryImpl;

public class AzureMQToFileAMQ {

    public static void main(String[] args) throws Exception {

        Main main = new Main();
        AMQPComponent connectionFactory = new AMQPComponent(
                ConnectionFactoryImpl
                        .createFromURL("amqps://"
                                + "dev.emea-uk-test.q:xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx@xxxxxxxxxxxxxxxxxxxxxxxxxxx.servicebus.windows.net"
                                + ":" + "5671"));
        main.bind("amqp", connectionFactory);
        main.addRouteBuilder(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("amqp:queue:dev.emea.uk.test.q?consumerType=Simple")
                        .process(exchange -> {
                            final String body = new String((byte[])exchange.getIn().getBody());
                            System.out.println(body);
                        });
            }
        });
        main.run();
    }
}