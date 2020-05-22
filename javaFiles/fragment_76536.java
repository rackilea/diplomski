channel.basicConsume(queueName, false, new DefaultConsumer(channel) {
    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        final byte msgBody = body; // a 'final' copy of the body that you can pass to the runnable
        final long msgTag = envelope.getDeliveryTag();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // handle the message here
                doStuff(msgBody);
                channel.basicAck(msgTag, false);
            }
        };
        threadPool.submit(runnable);
    }
});