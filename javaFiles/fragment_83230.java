RedisClient client = RedisClient.create("redis://" + host + "/0");
StatefulRedisPubSubConnection<String, String> con = client.connectPubSub();

RedisPubSubListener<String, String> listener = new RedisPubSubAdapter<String, String>() {

    @Override
    public void message(String channel, String message) {
        System.out.println(String.format("Channel: %s, Message: %s", channel, message));
    }
};

con.addListener(listener);
RedisPubSubCommands<String, String> sync = con.sync();
sync.subscribe("channel");