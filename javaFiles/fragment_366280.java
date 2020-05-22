public class Worker implements Runnable {
    private final BlockingQueue<Query> inbox;
    private final BlockingQueue<Result> outbox;

    public Worker(BlockingQueue<Query> inbox, BlockingQueue<Result> outbox) {
        // create LDAP connection
        this.inbox = inbox;
        this.outbox = outbox;
    }

    public void run() {
        try {
            while(true) {
                // waits for a Query to be available
                Query query = inbox.take();
                // execute query
                outbox.add(new Result(/* result */));
            }
        } catch(InterruptedException e) {
          // log and restart? close LDAP connection and return?
        }
    }
}

public class Master {
   private final int x; // number of queries per second
   private final BlockingQueue<Query> outbox = new ArrayBlockingQueue<>(4 * x);
   private final BlockingQueue<Result> inbox = new ArrayBlockingQueue<>(4 * x);
   private final ScheduledThreadPoolExecutor executor;
   private final List<Future<?>> workers = new ArrayList<>(20);
   private final Future<?> receiver;

   public Master() {
     // initialize executor
     for(int i = 0; i < 20; i++) {
         Worker worker = new Worker(inbox, outbox);
         workers.add(executor.submit(worker));
     }

     receiver = executor.submit(new Runnable() {
         public void run() {
           while(!Thread.interrupted()) {
             try {
               Result result = inbox.take();
               // process result
             } catch(InterruptedException e) {
               return;
             }
           }
         }
     }
   }

   executor.scheduleWithFixedDelay(new Runnable() {
       public void run() {
           // add x queries to the queue
       }
   }, 0, 1, TimeUnit.SECONDS);
}