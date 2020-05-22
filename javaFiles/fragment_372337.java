public class PlayHZ
{
    @Test
    public void test() throws ExecutionException, InterruptedException
    {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IExecutorService executor = hz.getExecutorService("gather");
        Map<Member, Future<List<String>>> futures = executor.submitToAllMembers(new LockNameGather());
        Thread.sleep(1000);
        System.out.println("Found in member");
        for (Map.Entry<Member, Future<List<String>>> entry : futures.entrySet())
        {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue().get());
        }
    }

    @Test
    public void svr() throws InterruptedException
    {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void cli() throws InterruptedException
    {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        for (int i = 0; i < 100; i++)
        {
            ILock lock = hz.getLock("LOCK" + i);
            lock.lock();
        }
        Thread.sleep(Integer.MAX_VALUE);
    }

    private static class LockNameGather implements Callable<List<String>>, HazelcastInstanceAware, Serializable
    {
        transient HazelcastInstance hz;
        transient NodeEngineImpl node;

        @Override
        public List<String> call() throws Exception
        {
            node = ((HazelcastInstanceImpl) hz).node.getNodeEngine();
            LockService svc = node.getService(LockService.SERVICE_NAME);

            return svc.getAllLocks()
                      .stream()
                      .map(LockResource::getKey)
                      .map(d -> node.getSerializationService().createObjectDataInput(d))
                      .map((r) -> {
                          try
                          {
                              return r.readUTF();
                          } catch (IOException e)
                          {
                              throw new RuntimeException(e);
                          }
                      }).collect(Collectors.toList());
        }

        @Override
        public void setHazelcastInstance(HazelcastInstance hazelcastInstance)
        {
            hz = hazelcastInstance;
        }
    }
}