ExecutorService executor = Executors.newFixedThreadPool(10);
void signal(int signal){
for(Callable c:actionList){
  //submit Callable tasks to be executed by thread pool
  Future<String> future = executor.submit(callable);
  //add Future to the list, we can get return value using Future
  list.add(future);
}
}