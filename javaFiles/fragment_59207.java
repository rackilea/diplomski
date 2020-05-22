@Bean
public IntegrationFlow client() {
    return IntegrationFlows.from(() -> "foo", 
                    e -> e.poller(Pollers.fixedDelay(Duration.ofSeconds(5))))
            .handle(Tcp.outboundGateway(Tcp.netClient("localhost", 1234)))
            .transform(Transformers.objectToString())
            .handle((p, h) -> {
                System.out.println("Received:" + p);
                return null;
            })
            .get();
}