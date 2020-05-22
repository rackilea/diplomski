ExecutorService executor = Executors.newSingleThreadExecutor(); 

webClient.get().uri("/some/path/here").retrieve()
    .bodyToMono(GetLocationsResponse.class)
    .publishOn(Schedulers.fromExecutor(executor)) // next operation will go to this executor
    .subscribe(System.out::println); //still non-blocking

executor.awaitTermination(1, TimeUnit.SECONDS); //block current main thread