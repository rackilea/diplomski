ExecutorService es = Executors.newFixedThreadPool(numImg);
List<Callable> tasks = ...
for (int i = 0; i < numImg; i++) {
  tasks.add(your tasks);
}
List<Future<Object>> futures = es.invokeAll(tasks);