@SpringBootApplication
@EnableScheduling
public class So55154418Application {

    public static void main(String[] args) {
        SpringApplication.run(So55154418Application.class, args);
    }

    @Bean
    public IntegrationFlow server() {
        return IntegrationFlows.from(Tcp.inboundGateway(Tcp.netServer(1234)))
                .transform(Transformers.objectToString())
                .log()
                .handle((p, h) -> "OK")
                .get();
    }

    @Bean
    public IntegrationFlow client() {
        return IntegrationFlows.from(Gate.class)
                .handle(Tcp.outboundGateway(Tcp.netClient("localhost", 1234)))
                .transform(Transformers.objectToString())
                .handle((p, h) -> {
                    System.out.println("Received:" + p);
                    return null;
                })
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
            this.gateway.send("foo");
        }

    }

    public interface Gate {

        void send(String out);

    }

}