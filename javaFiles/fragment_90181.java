// Initialize thread pool
ExecutorService exec = Executors.newFixedThreadPool(10);

// every time you get a new job
Future<Object> result = exec.submit(new Task(job));

// when you want to collect the result
Object obj = result.get();