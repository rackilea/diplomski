List<Future<?>> futures = new ArrayList<Future<?>>();
futures.add(executorCompletionService.submit(A));
futures.add(executorCompletionService.submit(B));
futures.add(executorCompletionService.submit(C));
futures.add(executorCompletionService.submit(D));
futures.add(executorCompletionService.submit(E));

//This for loop will process the tasks in the order they are completed,  
//regardless of submission order
for (int i=0; i<futures.size(); i++) {
    ? result = executorCompletionService.take().get();
    // Some processing here
}