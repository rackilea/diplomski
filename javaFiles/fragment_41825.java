public class Runner{
    public static void main(String[] args) {
       // you can use newFixedThreadPool(...) if you need to submit multiple
       ExecutorService threadPool = Executors.newSingleThreadExecutor();
       // you could store this future in a collection if you have multiple
       Future<String> future = threadPool.submit(new MyClass());
       // after submitting the final job, we _must_ shutdown the pool
       threadPool.shutdown();

       // do other stuff in the "foreground" while MyClass runs in the background

       // wait for the background task to complete and gets its return value
       // this can throw an exception if the call() method threw
       String value = future.get();
       System.out.println(value);
    }
}