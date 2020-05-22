@Override
public void run(ApplicationArguments applicationArguments) throws Exception {
    List<Future<Message<String>>> futures = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        Message<String> message = MessageBuilder.withPayload("Some payload that created for message id: " + i)
                .build();
        log.info("Sending message " + i);
        futures.add(gateway.print(message));
    }
    futures.forEach(f -> {
        try {
            System.out.println(f.get());
        }
        catch (ExecutionException e) {
            System.out.println(e.getCause().getMessage());
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    });
}