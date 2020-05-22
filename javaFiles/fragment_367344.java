pool = Executors.newSingleThreadExecutor();
Future<String> future = pool.submit(new MyCallable(name, type));

// now you can do something in the foreground as your callable runs in the back

// when you are ready to get the background task's result you call get()
// get() waits for the callable to return with the value from call
// it also may throw an exception if the call() method threw
String value = future.get();