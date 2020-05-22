// contains the code where
public void testThread() {
    // add to a list
    List<Callable<String>> taskList = new ArrayList<Callable<String>>();
    Callable<String> callable1=null;
    for (int i = 0; i < 10; i++) {
        // create a callable for each method
        callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("The current thread is " + Thread.currentThread().getName());
                return method1();
                // return null;
            }
        };
        taskList.add(callable1);
    }

    // create a pool executor with 10 threads
    ExecutorService executor = Executors.newFixedThreadPool(10);

    try {
        List<Future<String>> futureList = executor.invokeAll(taskList);

    } catch (InterruptedException ie) {
    }
}