ExecutorService executor = ...;
ExecutorCompletionService ecs = new ExecutorCompletionService(executor);

for (int i = 0; i < totalTasks; i++) {
  ... ecs.submit(...); ...
}

for (int i = 0; i < totalTasks; i++) {
  ecs.take();
}