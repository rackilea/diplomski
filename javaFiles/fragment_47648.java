.process(new KeyedProcessFunction<String, MobileClickEvent, Object>() {
    private JedisCluster jedisCluster;

    @Override
    public void open(Configuration parameters) {
        jedisCluster = JedisClusterBuilder.getInstance(JedisClusterEnum.THIRD);
    }

    @Override
    public void processElement(MobileClickEvent value, Context ctx, Collector<Object> out) throws Exception {
        String key = ctx.getCurrentKey();
        jedisCluster.hincrBy(REDIS_PREFIX + key, "click", 1);
        jedisCluster.expire(REDIS_PREFIX + key, 60 * 10);
    }
});