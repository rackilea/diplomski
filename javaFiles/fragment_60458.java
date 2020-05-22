for (int i = 1; i <= 100; i++) {
    final int id = i % numThreads;
    Future<?> result = executor.submit(new Runnable() {
        public void run() {
            list.get(id).run(data);
        }
    });
    futures.add(result);
}