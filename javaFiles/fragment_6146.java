public class ThreadMain {

    public static void main(String args[]) {
        try {
            // start async(threaded) workers
            ExecutorService execuator = Executors.newFixedThreadPool(5);
            List<Future<String>> workers = new ArrayList<Future<String>>();
            for (int idx=0; idx < 10; idx++)
                workers.add( execuator.submit(new ReadTest()) );

            // loop until all workers is done, results may arrive in random order,
            // if none is ready then do something else while waiting for next result.
            while(!workers.isEmpty()) {
               Future<String> worker=null;
               for(int idx=0; idx < workers.size(); idx++) {
                  worker = workers.get(idx);
                  if (worker.isDone()) {
                     worker.remove(idx);
                     break;
                  }
                  worker = null;
               }

               if (worker==null) {
                  Thread.sleep(500); // do something else, like idle
               } else {
                  System.out.println("Worker is done with results " + worker.get() );
               }
            }

            execuator.shutdown();
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
    }

}