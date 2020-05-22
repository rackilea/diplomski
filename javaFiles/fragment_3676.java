HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        IScheduledExecutorService scheduler = instance.getScheduledExecutorService("scheduler");
        IScheduledFuture future = scheduler.schedule(named("MyTask",
                new EchoTask("foobar")), 1, TimeUnit.SECONDS);

        Object result = future.get();
        System.out.println(future.getHandler().getTaskName() + " result: " + result);

        future.dispose();

        System.out.println("Press any key to exit");
        System.in.read();
        Hazelcast.shutdownAll();