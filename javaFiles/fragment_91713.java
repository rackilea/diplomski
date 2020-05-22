Collection<Callable<YourResults>> tasks = new List<>(inputs.size());
for (YourInput i : inputs) 
  tasks.add(new YourTask(i));
ExecutorService workers = Executors.newFixedThreadPool(10);
/* The next call blocks while the worker threads complete all tasks. */
List<Future<YourResult>> results = workers.invokeAll(tasks);
workers.shutdown();
for (Future<YourResult> f : results) {
  YourResult r = f.get();
  /* Do whatever it is you do with the results. */
  ...
}