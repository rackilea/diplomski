JedisPool pool = new JedisPoolBuilder()
    .withFailoverConfiguration(
        "localhost:2838", // ZooKeeper cluster URL
        Arrays.asList( // List of redis servers
            new HostConfiguration("localhost", 7000), 
            new HostConfiguration("localhost", 7001))) 
    .build();

pool.withJedis(new JedisFunction() {
    @Override
    public void execute(final JedisActions jedis) throws Exception {
        jedis.ping();
    }
});