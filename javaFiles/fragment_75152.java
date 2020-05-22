Collection<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>(16);
for (Model m : models) {
  tasks.add(m.simulationTask());
}

ExecutorService executor = Executors.newFixedThreadPool(nThread);
try {
  executor.invokeAll(tasks);
} catch(InterruptedException ie) {
  // Handle this
}