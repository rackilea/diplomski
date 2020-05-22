final CompletionService service = new ExecutorCompletionService(Executors.newFixedThreadPool(5));
Runnable taskGenerator = new Runnable() {
    public void run() {
        // Seed the service
        for (int i = 0; i < 100; ++i) {
            service.submit(createNewTask());
        }
        // As tasks complete create new ones
        while (true) {
            Future<Something> result = service.take();
            processResult(result.get());
            service.submit(createNewTask());
        }
    }
};
new Thread(taskGenerator).start();