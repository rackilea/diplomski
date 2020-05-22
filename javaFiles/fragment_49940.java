Flux<String> source = Flux.just("a", "b", "c");
source.subscribe(new BaseSubscriber<String>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(1); // <-- here
            }

            @Override
            protected void hookOnNext(String value) {
                request(1); // <-- here
                System.out.println(value);
            }
        });