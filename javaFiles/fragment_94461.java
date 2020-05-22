//Use a Callable instead of Runnable to be able to throw your exception
Callable<Void> c = new Callable<Void> () {
    public Void call() throws YourException {
        //run your task here which can throw YourException
        return null;
    }
}

//Use an ExecutorService to manage your threads and monitor the futures
ExecutorService executor = Executors.newCachedThreadPool();
List<Future> futures = new ArrayList<Future> ();

//Submit your tasks (equivalent to new Thread(c).start();)
for (int i = 0; i < 5; i++) {
    futures.add(executor.submit(c));
}

//Monitor the future to check if your tasks threw exceptions
for (Future f : futures) {
    try {
        f.get();
    } catch (ExecutionException e) {
        //encountered an exception in your task => stop submitting tasks
    }
}