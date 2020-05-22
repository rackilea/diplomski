Arrays.asList(11, 12, 13, 14, 15)
        .stream() 
        .map(n -> Observable.just(n)) 
        .map(o -> o 
                .observeOn(Schedulers.computation()) 
                .flatMap(Main::delayedIdentity) 
                .subscribe(Main::println)) 
        .collect(Collectors.toSet());