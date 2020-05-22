ExecutorService executorService = Executors.newFixedThreadPool(foos.size());
List<Callable> tasks = new ArrayList<>();
for (Foo foo : foos) {
  tasks.add(new MyCallable(foo));
 }
 executorService.invokeAll(tasks);