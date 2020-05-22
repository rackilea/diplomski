@Autowired
private ConfigurableListableBeanFactory beanFactory;

public AbstractClientConnectionFactory clientConnectionFactory(String hostName, int port) {
    TcpNetClientConnectionFactory server = new TcpNetClientConnectionFactory(hostName, port);
    server.setSingleUse(false);
    server.setSoTimeout(300000);
    server = (TcpNetClientConnectionFactory) this.beanFactory.initializeBean(server, "cf");
    this.beanFactory.registerSingleton("cf", server);
    return server;
}

public TcpInboundGateway tcpInbound(AbstractClientConnectionFactory connectionFactory) {
    TcpInboundGateway gate = new TcpInboundGateway();
    gate.setConnectionFactory(connectionFactory);
    gate.setClientMode(true);
    gate.setRetryInterval(60000);
    gate.setRequestChannelName("toTcp");
    gate = (TcpInboundGateway) this.beanFactory.initializeBean(gate, "gate");
    this.beanFactory.registerSingleton("gate", gate);
    return gate;
}