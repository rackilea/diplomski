RedisPubSubListener<String, String> listener = new RedisPubSubAdapter<String, String>() {

    @Override
    public void message(String channel, String message) {
        System.out.println(String.format("Channel: %s, Message: %s", channel, message));
    }
};

con.addListener(listener);
RedisPubSubCommands<String, String> sync = con.sync();
sync.subscribe("channel");

StatefulRedisConnection<String, String> sender = client.connect();

sender.sync().publish("channel", "Message 1");
sender.sync().publish("channel", "Message 2");

latch.await();

Thread.sleep(1000);