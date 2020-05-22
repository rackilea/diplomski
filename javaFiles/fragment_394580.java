List<Callable<String>> tasks = ....;
Executor ex = Executors.newFixedThreadPool(10);
ExecutorCompletionService<String> ecs = new ExecutorCompletionService<String>(ex);
for (Callable<String> task : tasks) 
    ecs.submit(task);
for(int i = 0; i < tasks.size(); i++) {
    String result = ecs.take().get();
    //Do something with result
}