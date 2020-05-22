ExecutorService es = Executors.newFixedThreadPool(nThreads);

for(final MyType mt: myCollection)
    es.submit(new Runnable() {
       public void run() {
           doStuffWith(mt);
       }
    });
es.shutdown();
es.awaitTermination(1, TimeUnit.HOURS);