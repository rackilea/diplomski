public static void registerReceiver(QueueClient queueClient, ExecutorService executorService) throws Exception {
    queueClient.registerMessageHandler(
        new IMessageHandler() {
            public CompletableFuture<Void> onMessageAsync(IMessage message) {
                if (message.getLabel() != null &&
                       message.getContentType() != null &&
                       message.getLabel().contentEquals("TestMessage") &&
                       message.getContentType().contentEquals("text/plain")) {

                    System.out.printf(
                        "\nMessage received: \n -->MessageId = %s\n -->ContentType = %s\n -->Content = %s\n",
                        message.getMessageId(),
                        message.getContentType(),
                        new String(message.getBody())
                    );
                    return queueClient.completeAsync(message.getLockToken());
                }
                return queueClient.abandonAsync(message.getLockToken());
            }

            public void notifyException(Throwable throwable, ExceptionPhase exceptionPhase) {
                System.out.printf(exceptionPhase + "-" + throwable.getMessage());
            }
        },
        new MessageHandlerOptions(1, false, Duration.ofSeconds(10)),
        executorService
    );
}

public static void sendMessages(QueueClient client) throws ServiceBusException, InterruptedException {
    for (int i = 0; i < 100; i++) {
        String messageId = Integer.toString(i);
        Message message = new Message("This is message " + i);
        message.setContentType("text/plain");
        message.setLabel("TestMessage");
        message.setMessageId(messageId);
        message.setTimeToLive(Duration.ofMinutes(10));
        client.send(message);
        System.out.printf("Message sent: Id = %s \n", message.getMessageId());
    }
}

public static void main(String[] args) throws Exception {
    String connectionString = "your_connection_string, Endpoint=sb://j*9.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=V*=";
    String queueName = "your_queue_name, testQueue";

    QueueClient client = new QueueClient(new ConnectionStringBuilder(connectionString, queueName), ReceiveMode.PEEKLOCK);
    sendMessages(client);
    client.close();

    QueueClient receiveClient = new QueueClient(new ConnectionStringBuilder(connectionString, queueName), ReceiveMode.PEEKLOCK);
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    registerReceiver(receiveClient, executorService);

    Thread.sleep(60 * 1000); // Wait for 60 seconds to receive all the messages.
    receiveClient.close();
    executorService.shutdown();
}