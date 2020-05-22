@Bean
public TcpInboundGateway gateway(AbstractConnectionFactory connectionFactory) throws Exception {
    TcpInboundGateway gate = new TcpInboundGateway();
    gate.setConnectionFactory(connectionFactory);
    gate.setRequestChannel(new RendezvousChannel());
    return gate;
}

@Bean
public TcpConnectionFactoryFactoryBean connectionFactory() {
    TcpConnectionFactoryFactoryBean fact = new TcpConnectionFactoryFactoryBean();
    fact.setType("server");
    fact.setPort(5555);
    return fact;
}