// Do this once, may be at the beginning of application
pool = new JedisSentinelPool(...);

// For every operation
jedis = pool.getResource();
// Do your operation(s)
jedis.close();

// Once, at the end of application
pool.destroy();