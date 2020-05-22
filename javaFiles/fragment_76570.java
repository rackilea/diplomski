final List<Object> results = Collections.synchronizedList(new ArrayList<Object>());
final CountDownLatch latch = new CountDownLatch(10);//suppose you'll have 10 futures

do {
    Future<Void> future = executor.submit(new Callable<Void>() {
        @Override
        public Void call() throws Exception {
            // action
            latch.countDown();//decrease the latch count
            results.add(result); // some result
            return null;
        }
    });

    futures.add(future);
} while (true);

executor.shutdown();

latch.await(); //This will block till latch.countDown() has been called 10 times.

//Now results has all the outputs, do what you want with them.