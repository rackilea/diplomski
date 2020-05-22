int NUM_THREADS = Runtime.getRuntime().availableProcessors();
ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
CompletionService<MyFileData> completionService = new ExecutorCompletionService<MyFileData>(executor);

for (File f : files) futures.add(completionService.submit(new MyCallable(f)));

for(int i = 0; i < futures.size(); i++) {
    Future<MyFileData> next = completionService.take();
    sequentialOperation(next.get());
}