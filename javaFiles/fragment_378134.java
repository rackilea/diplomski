@SpringBootApplication
@EnableScheduling
public class Igh2755Application {

    public static void main(String[] args) {
        SpringApplication.run(Igh2755Application.class, args);
    }

    private final BlockingQueue<CorrelationData> futures = new LinkedBlockingQueue<>();

    @Bean
    public ApplicationRunner runner(RabbitTemplate template) {
        return args -> {
            SuccessCallback<? super Confirm> successCallback = confirm -> {
                System.out.println((confirm.isAck() ? "A" : "Na") + "ck received");
            };
            FailureCallback failureCallback = throwable -> {
                System.out.println(throwable.getMessage());
            };

            // Good - ack
            CorrelationData correlationData = new CorrelationData("good");
            correlationData.getFuture().addCallback(successCallback, failureCallback);
            this.futures.put(correlationData);
            template.convertAndSend("", "foo", "data", correlationData);

            // Missing exchange nack, no return
            correlationData = new CorrelationData("missing exchange");
            correlationData.getFuture().addCallback(successCallback, failureCallback);
            this.futures.put(correlationData);
            template.convertAndSend("missing exchange", "foo", "data", correlationData);

            // Missing queue ack, with return
            correlationData = new CorrelationData("missing queue");
            correlationData.getFuture().addCallback(successCallback, failureCallback);
            this.futures.put(correlationData);
            template.convertAndSend("", "missing queue", "data", correlationData);
        };
    }

    @Scheduled(fixedDelay = 5_000)
    public void checkForMissingAcks() {
        System.out.println("Checking pending acks");
        CorrelationData correlationData = this.futures.poll();
        while (correlationData != null) {
            try {
                if (correlationData.getFuture().get(10, TimeUnit.SECONDS).isAck()) {
                    if (correlationData.getReturnedMessage() == null) {
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