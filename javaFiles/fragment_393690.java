@Autowired
private IntegrationFlowContext flowContext;

public void tcpInbound(String host, int port, String flowId) {
    IntegrationFlow flow = IntegrationFlows.from(
                Tcp.inboundGateway(Tcp.netClient(host, port))
                    .clientMode(true))
            .channel("toTcp")
            .get();
    this.flowContext.registration(flow).id(flowId).register();
}