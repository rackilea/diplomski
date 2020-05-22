Callable<String> myCallable = ...;
Future<String> future = myExector.submit(myCallable);

// Do something else until myCallable.isDone() returns true.
try {
    String result = future.get();
}catch(ExecutionException e){
    // Handle error, perhaps create new Callable to submit.
}