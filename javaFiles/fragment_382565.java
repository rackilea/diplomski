@RequestMethod
public String myXmlMethod(Param params) {
    String hash = params.getHash(); ////assume a value identifying a certain form of logic
    FutureTask<MyResult> task = new FutureTask<>(new Callable<MyResult>() {
        @Override
        public MyResult call() throws Exception {
            // My task here
        }
    });
    // This boolean means we are the first to insert the entry
    boolean inserted = true;
    try {
        FutureTask<MyResult> previous = map.putIfAbsent(hash, task);
        if (previous == null) {
            // The task has not been defined so far so we execute it
            task.run();
        } else {
            // the task has already been defined
            task = previous;
            inserted = false;
        }
        // we wait until we get the result
        return task.get();
    } finally {
        // Clean up the per key map but only if our insertion succeeded and with our future
        if (inserted) {
           map.remove(hash, task);
        }
    }
}