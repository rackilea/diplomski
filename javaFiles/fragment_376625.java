final ResponseHandler handler = ... // has many methods.

// use a map or array or enum to translate transIds into method names.
final Method method = handler.getClass().getMethod(taskArray[taskID]); 
executorService.submit(new Callable<Void>() {
    public Void call() throws Exception {
         method.invoke(handler);
    }
});