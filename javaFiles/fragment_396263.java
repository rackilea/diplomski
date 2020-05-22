SubscribableChannel channel = context.getBean("fromRabbit", SubscribableChannel.class);

    channel.subscribe(new MessageHandler() {

        @Override
        public void handleMessage(Message<?> message) throws MessagingException {
            System.out.println("Got " + message);
        }
    });