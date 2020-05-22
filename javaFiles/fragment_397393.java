package be.jmshub.jmsremotejndiproducer;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class Broker {

    public static void main(String[] args) throws Exception {
        BrokerService broker = BrokerFactory.createBroker("xbean:foo.xml");
        broker.setPersistent(false);
        broker.start();
        broker.waitUntilStarted();
    }
}