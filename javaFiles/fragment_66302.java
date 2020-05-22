@Bean
public BrokerService broker() throws Exception {
    final BrokerService broker = new BrokerService();
    broker.addConnector("tcp://localhost:61616");
    broker.addConnector("vm://localhost");
    broker.setPersistent(false);
    return broker;
}