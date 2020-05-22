Callable<String> task = new Echo(input);

   String key = "foo";
   IMap map1 = hz.getMap("m1");
   IMap map2 = hz.getMap("m2");
   map1.put(key,1);
   map2.put(key,2);

   IExecutorService executorService = hz.getExecutorService("default");
   Future<String> future = executorService.submitToKeyOwner(task, key);
   String echoResult = future.get();