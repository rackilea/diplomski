Config config = new Config();
// for single server
config.useSingleServer()
      .setAddress("127.0.0.1:6379");
// or 
// for master/slave servers
config.useSentinelConnection()
      .setMasterName("mymaster")
      .addSentinelAddress("127.0.0.1:26389", "127.0.0.1:26379");

Redisson redisson = Redisson.create(config);

Lock lock = redisson.getLock("anyLock");
try {
   // unlock automatically after 10 seconds of hold
   lock.lock(10, TimeUnit.SECONDS);

} finally {
   lock.unlock();
}

...

redisson.shutdown();