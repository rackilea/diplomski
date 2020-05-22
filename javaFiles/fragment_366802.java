ExecutorService es =
Future<Type> future = ex.submit(new Callable<Type>() {
    public Type call() throws Exception {
        // do something
        return result;
    }
});

// later
try {
    Type result = future.get();
} catch(ExecutionException e) {
    Throwable exceptionThrown = e.getCause();
}