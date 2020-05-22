@SpringBootApplication
@EnableScheduling
public class Igh2755Application {

    public static void main(String[] args) {
        SpringApplication.run(Igh2755Application.class, args);
    }

    private final BlockingQueue<CorrelationData> futures = new LinkedBlockingQueue<>();

    public interface Gate {

        void send(@Header("exchange") String exchange, @Header("rk") String rk, String payload);

    }

    @Bean
    @DependsOn("flow")
    public ApplicationRunner runner(Gate gate) {
        return args -> {
            gate.send("", "foo", "good");
            gate.send("junque", "rk", "missing exchange");
            gate.send("", "junque", "missing queue");
        };
    }

    @Bean
    public IntegrationFlow flow(RabbitTemplate template) {
        return IntegrationFlows.from(Gate.class)
                    .handle(Amqp.outboundAdapter(template)
                            .confirmCorrelationExpression("@correlationCreator.create(#root)")
                            .exchangeNameExpression("headers.exchange")
                            .routingKeyExpression("headers.rk")
                            .returnChannel(returns())
                            .confirmAckChannel(acks())
                            .confirmNackChannel(acks()))
                    .get();
    }

    @Bean
    public MessageChannel acks() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel returns() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow ackFlow() {
        return IntegrationFlows.from("acks")
                /*
                 * Work around a bug because the correlation data is wrapped and so the
                 * wrong future is completed.
                 */
                .handle(m -> {
                    System.out.println(m);
                    if (m instanceof ErrorMessage) { // NACK
                        NackedAmqpMessageException nme = (NackedAmqpMessageException) m.getPayload();
                        CorrelationData correlationData = (CorrelationData) nme.getCorrelationData();
                        correlationData.getFuture().set(new Confirm(false, "Message was returned"));
                    }
                    else {
                        ((CorrelationData) m.getPayload()).getFuture().set(new Confirm(true, null));
                    }
                })
                .get();
    }

    @Bean
    public IntegrationFlow retFlow() {
        return IntegrationFlows.from("returns")
                .handle(System.out::println)
                .get();
    }

    @Bean
    public CorrelationCreator correlationCreator() {
        return new CorrelationCreator(this.futures);
    }

    public static class CorrelationCreator {

        private final BlockingQueue<CorrelationData> futures;

        public CorrelationCreator(BlockingQueue<CorrelationData> futures) {
            this.futures = futures;
        }

        public CorrelationData create(Message<String> message) {
            CorrelationData data = new CorrelationData(message.getPayload());
            this.futures.add(data);
            return data;
        }

    }

    @Scheduled(fixedDelay = 5_000)
    public void checkForMissingAcks() {
        System.out.println("Checking pending acks");
        CorrelationData correlationData = this.futures.poll();
        while (correlationData != null) {
            try {
                if (correlationData.getFuture().get(10, TimeUnit.SECONDS).isAck()) {
                    if (correlationData.getReturnedMessage() == null
                            && !correlationData.getId().equals("Message was returned")) {
                        System.out.println("Ack received OK for " + correlationData.getId());
                    }
                    else {
                        System.out.println("Message returned for " + correlationData.getId());
                    }
                }
                else {
                    System.out.println("Nack received for " + correlationData.getId());
                }
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Interrupted");
            }
            catch (ExecutionException e) {
                System.out.println("Failed to get an ack " + e.getCause().getMessage());

            }
            catch (TimeoutException e) {
                System.out.println("Timed out waiting for ack for " + correlationData.getId());
            }
            correlationData = this.futures.poll();
        }
        System.out.println("No pending acks, exiting");
    }

}