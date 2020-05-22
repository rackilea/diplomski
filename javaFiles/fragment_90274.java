ThreadPool pool = Executors.newFixedThreadPool(10); // 10 threads in the pool
ArrayList<Callable> collectionOfCallables = new ArrayList<Callable>( );
for (...) {
  Callable callable = new Callable<Foo>() { public Foo call() { COMPUTE INTENSIVE SECTION } }
  collectionOfCallables.add(callable);
}

ArrayList<Future<Foo>> results = pool.invokeAll( collectionOfCallables );

pool.awaitTermination(5, TimeUnit.MINUTES ); // blocks till everything is done or 5 minutes have passed.