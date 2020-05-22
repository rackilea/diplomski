final CountDownLatch latch = new CountDownLatch(2);
RedisPubSubListener<String, String> listener = new RedisPubSubAdapter<String, String>() {

    @Override
    public void message(String channel, String message) {
        System.out.println(String.format("Channel: %s, Message: %s", channel, message));
        latch.countDown();
    }
};

// ...
sender.sync().publish("channel", "Message 2");

latch.await();