ExecutorService service = Executors.newCachedThreadPool();
// My task
Task task = new Task();
// Submit the task and get the corresponding future
Future<?> future = service.submit(task);
...
// Cancel the task which will interrupt the thread that was executing the 
// task if any
future.cancel(true);