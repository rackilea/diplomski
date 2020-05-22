public class MyThreadFactory implements ThreadFactory {
   public Thread newThread(Runnable r) {
     Thread t =  new Thread(r);
     t.setPriority(Thread.MAX_PRIORITY); //Or whatever priority
     return t;
   }
 }

ExecutorService es = Executors.newFixedThreadPool(NTHREADS,new MyThreadFactory());