rxBus.toObservable()
    .ofType(Events.IncomingMsg.class)
    // I'm making a big assumption that getMessage() is a thing here.
    .map(new Func1<Events.IncomingMsg, String>() {

        @Override
        public String call(final Events.IncomingMsg event) {
            return event.getMessage().getString("location");
        }

    })
    .subscribe(new Action1<String>() {

        @Override
        public void call(final String warehouse) {
            // Do something with warehouse here.
        }

    });