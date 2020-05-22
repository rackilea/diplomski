// create a thread pool with as many workers as there are jobs
ExecutorService threadPool = Executors.newCachedThreadPool();
List<Future<Map<String, Integer>>> futures =
    new ArrayList<Future<Map<String, Integer>>>();
futures.add(threadPool.submit(new SecondClass(s1)));
futures.add(threadPool.submit(new SecondClass(s2)));
futures.add(threadPool.submit(new SecondClass(s3)));
futures.add(threadPool.submit(new SecondClass(s4)));
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();
...
Map<String, Integer> all = new HashMap<String, Integer>();
for (Future<Map<String, Integer>> future : futures) {
    // future.get() throws an exception if your call method throws
    all.putAll(future.get());
}