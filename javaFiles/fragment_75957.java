Flux.just("userA", "userB", "userC")
            .parallel(2)
            .runOn(Schedulers.parallel())
            .map(userString -> {
                return lookupService.lookup(userString);
            })
            .doOnNext(user -> {
                // if you want to do something on each user
                // will return void so if you want to log something
                // or handle each user
            }).subscribe();