@Bean
    public IntegrationFlow inUdpAdapter() {
        return IntegrationFlows.from(Udp.inboundAdapter(0))
                .channel(udpIn())
                .get();
    }

    @Bean
    public QueueChannel udpIn() {
        return new QueueChannel();
    }

    @Bean
    public IntegrationFlow outUdpAdapter() {
        return f -> f.handle(Udp.outboundAdapter(m -> m.getHeaders().get("udp_dest")));
    }