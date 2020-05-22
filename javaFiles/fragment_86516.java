ExecutorService executor = Executors.newWorkStealingPool();
CompletionService completor = new CompletionService(executor);
int count = stream.map(completor::submit).count();
while(count-- > 0) {
  SomeClass obj = completor.take();
  consume(obj);
}