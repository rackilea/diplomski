Flowable.fromIterable(array)
                .parallel(3) // number of items in parallel
                .runOn(Schedulers.newThread()) // the desired scheduler
                .map(item -> {
                    try {
                        System.out.println(1);
                        Thread.sleep(3000);
                        System.out.println(2);
                    } catch (Exception e) {

                    }

                    return Completable.complete();
                })
        .sequential().subscribe();