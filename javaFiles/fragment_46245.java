ExecutorService executor = Executors.newFixedThreadPool(50);    
CompletionService<Obejct> completionService = new ExecutorCompletionService<> (executor);
for(String str : strList) {
    completionService.submit(new LittleDwarfWorker(...));
}

for ( int i = 0; i < strList.size(); i++ ) {
  try {
    Object result = completionService.take().get();
    // ... do whatever something with the object

  } catch ( InterruptedException | ExecutionException e ) {
    e.printStackTrace();
  }
}

executor.shutdown();