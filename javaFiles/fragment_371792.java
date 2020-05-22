Observable.range(0, 1000)
            .concatMap(new Func1<Integer, Observable<?>>() {
                @Override
                public Observable<?> call(Integer integer) {
                    return produceChunkOf(10)
                            .flatMap(new Func1<Object, Observable<?>>() {
                                @Override
                                public Observable<?> call(Object item) {
                                    return consume(item)
                                            .observeOn(Schedulers.io());
                                }
                            }, 10)
                            .toList();
                }
            });