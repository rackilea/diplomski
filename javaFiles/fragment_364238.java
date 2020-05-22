for (int i = 0; i < coresNumber; ++i) {
    threads.add(executor.submit(new CallableC(splittedList.get(i),)));
}
// This will wait for all the futures to terminate (thanks to f.get())
// And then, all the completable futures will be added to an array of futures that will also be waited upon
CompletableFuture.allOf(
    uglyList.stream().flatMap(f -> f.get().values().stream()).toArray(CompletableFuture[]::new)
).join();