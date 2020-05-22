public class CallableTest
{
public static void main(String args[]) throws Exception
{
    ExecutorService executor = Executors.newFixedThreadPool(10);
    ExecutorService pool= Executors.newFixedThreadPool(10);
    List<Future<Long>> futureList = new ArrayList<Future<Long>>();
    Set<CallableDemo> callList = new HashSet<CallableDemo>();

         //submit Callable tasks to be executed by thread pool
         //<Long> future = executor.submit(callable);
         //add Future to the list, we can get return value using Future
         //list.add(future);

         callList.add(new CallableDemo(0L));
         callList.add(new CallableDemo(10L));
         callList.add(new CallableDemo(20L));
         callList.add(new CallableDemo(30L));
         callList.add(new CallableDemo(40L));
         callList.add(new CallableDemo(50L));
         callList.add(new CallableDemo(-600L));
         callList.add(new CallableDemo(-700L));
         callList.add(new CallableDemo(-800L));
         callList.add(new CallableDemo(-900L));

        futureList = pool.invokeAll(callList, 15L, TimeUnit.SECONDS);

        for(Future<Long> fut : futureList){
                try {
                    //print the return value of Future, notice the output delay in console
                    // because Future.get() waits for task to get completed
                    if( !fut.isCancelled())
                        System.out.println(new Date()+ "::"+fut.get());
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    System.out.println("Done :)");
                    //Thread.currentThread().interrupt();
                }
                catch (ExecutionException e) {
                    //e.printStackTrace();
                    System.out.println("Done :)");
                    //Thread.currentThread().interrupt();
                }
            }
            //shut down the executor service now
            executor.shutdown();
            System.out.println("Done :)");
}
}