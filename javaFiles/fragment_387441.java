Executor queryExecutor = Executors.newFixedThreadPool(Math.min(animalList.size(), 10),
    r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });
List<Animal> result =  animalList.stream()
    .map(animal -> CompletableFuture.completedFuture(animal.getBreed())
        .thenApplyAsync(breed -> queryDatabase(breed), queryExecutor))
    .collect(Collectors.toList()).stream()
    .flatMap(cf -> cf.join().stream())
    .collect(Collectors.toList());