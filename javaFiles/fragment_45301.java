.publishSubscribeChannel(s -> s
                        .applySequence(true)
                        .subscribe(f -> f
                                .handle((p, h) -> "Hello"))
                        .subscribe(f -> f
                                .handle((p, h) -> "World!"))
                );