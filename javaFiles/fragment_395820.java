final ExecutorService testExecutor = Executors.newFixedThreadPool(10);
final List<Future<?>> executeDatas = new ArrayList<Future<?>>();

for (ExampleType ex : exampleData) {
    Future<?> executeData = testExecutor.submit(new Runnable() {
        @Override
        public void run() {
            exampleFunction(ex.getSomeData());
        }
    });
    executeDatas.add(executeData);
}

for (Future<?> executeData : executeDatas) {
    // calling get in loop to effectively wait for all the futures to finish
    executeData.get();
}