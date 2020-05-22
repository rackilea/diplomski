@Bean
    public IntegrationFlow client() {
        return IntegrationFlows.from(Gate.class)
                .handle(Tcp.outboundGateway(Tcp.netClient("localhost", 1234)))
                .transform(Transformers.objectToString())
                .get();
    }

    @Bean
    @DependsOn("client")
    public Runner runner(Gate gateway) {
        return new Runner(gateway);
    }

    public static class Runner {

        private final Gate gateway;

        public Runner(Gate gateway) {
            this.gateway = gateway;
        }

        @Scheduled(fixedDelay = 5000)
        public void run() {
            String reply = this.gateway.sendAndReceive("foo"); // null for timeout
            System.out.println("Received:" + reply);
        }

    }

    public interface Gate {

        @Gateway(replyTimeout = 5000)
        String sendAndReceive(String out);

    }