Flow.Publisher<Byte> bytes = ...;

Flowable.fromPublisher(
        FlowAdapters.toPublisher(
            bytes
        )
    ).toList()
        .map(byteList -> new String(convert(byteList)))
        .subscribe((String string) -> {
            System.out.println(string);
        });