class MyThread {
    void doSomething() {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.exists(key);
        }
    }
}