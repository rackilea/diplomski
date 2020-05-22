List<Future<ParallelExecutor>> tasks = new ArrayList<>();
ExecutorService tp = Executors.newFixedThreadPool(10);
for (final TableInfo table : commandList) {
   ParallelExecutor pe = new ParallelExecutor(table);
   tasks.add(tp.submit(pe));
}

for (Future<ParallelExecutor > p : tasks) {
   p.get(); // with timeout p.get(10, TimeUnit.SECONDS);
}

tp.shutdown();