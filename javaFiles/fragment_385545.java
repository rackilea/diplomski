ExecutorService executor = Executors.newFixedThreadPool(4); // or another kind of executor
List<Future<Foo>> futures = new ArrayList<>();
for(int i = 0;i < nrRooms; i++) {
    futures.add(executor.submit(new FitnessCallable(chromosome)));
}
...
// Time to check the results
for(Future<Foo> f : futures) {
    Foo result = f.get();  // Block and get the result
}