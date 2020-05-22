List<Object> results = getRedisTemplate().executePipelined(new RedisCallback<Object>() {

    @Override
    public Object doInRedis(RedisConnection connection) {

            connection.hMGet(key.getBytes(), params);

            return null;
    }
});

List<Object> hmget = (List<Object>) results.get(0);