ExecutorService queryExecutor=Executors.newFixedThreadPool(Math.min(animalList.size(),10));
Map<Boolean,List<Animal>> result =  animalList.stream()
    .map(animal -> CompletableFuture.completedFuture(animal.getBreed())
        .thenApplyAsync(breed -> queryDatabase(breed), queryExecutor))
    .collect(Collectors.toList()).stream()
    .flatMap(cf -> cf.join().stream())
    .collect(Collectors.partitioningBy(animal -> animal.getSpecie() == cat));
List<Animal> catList = result.get(true), dogList = result.get(false);
queryExecutor.shutdown();