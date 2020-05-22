public static void eventListener() throws InterruptedException {
  MessageReceiver receiver = new MessageReceiver() {
    @Override
    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
      System.out.println("Received message: " + message.getData().toStringUtf8());
      consumer.ack();
    }
  };
  Subscriber subscriber = null;
  try {
    subscriber = Subscriber.newBuilder(subscription, receiver)
        .setCredentialsProvider(FixedCredentialsProvider.create(creds)).build();
    subscriber.addListener(new Subscriber.Listener() {
      @Override
      public void failed(Subscriber.State from, Throwable failure) {
        // Handle failure. This is called when the Subscriber encountered a fatal error
        // and is
        // shutting down.
        System.err.println(failure);
      }
    }, MoreExecutors.directExecutor());
    subscriber.startAsync().awaitRunning();
    subscriber.awaitTerminated();
  } finally {
    if (subscriber != null) {
      subscriber.stopAsync().awaitTerminated();
    }
  }
}

public static void main(String[] args) throws InterruptedException {
  eventListener();
}