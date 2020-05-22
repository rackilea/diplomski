public class Test {
ExecutorService executor;

public Test() {
    /* I used an executor that creates a new thread every time creating a server requests object
     * you might need to create a thread pool instead, depending on your application
     * */
    executor = Executors.newSingleThreadExecutor();
}

private JSONObject doTheWork() {
    // init 
    Callable<JSONObject> callable;
    Future<JSONObject> future;
    JSONObject jsonResult = null;

    try {
        // create callable object with desired job
        callable = new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                JSONObject jsonResult = new JSONObject();

                // connect to the server

                // insert desired data into json object

                // and return the json object 
                return jsonResult; 
            }
        };

        future = executor.submit(callable);
        jsonResult = future.get();
    } catch(InterruptedException ex) {
        // Log exception at first so you could know if something went wrong and needs to be fixed
    } catch(ExecutionException ex) {
        // Log exception at first so you could know if something went wrong and needs to be fixed
    }

    return jsonResult;
}