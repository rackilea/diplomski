CompletionService<Result> ecs = new ExecutorCompletionService<Result>(executor);
for (Callable<Result> s : solvers)
    ecs.submit(s);
int n = solvers.size();
List<Result> batch = new ArrayList<Result>();
for (int i = 0; i < n; ++i) {
    Result r = ecs.take().get();
    batch.add(r);
    if (batch.size() >= 100) {
       process(batch);
       batch.clear();
    }
}
if (!batch.isEmpty()) {
    process(batch);
}