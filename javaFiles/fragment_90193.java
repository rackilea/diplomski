rxBus.toObservable()
    .ofType(Events.IncomingMsg.class)
    // I'm making a big assumption that getMessage() is a thing here.
    .map((event) -> event.getMessage())
    .subscribe((message) -> {
        // Do thing with message here!
    });