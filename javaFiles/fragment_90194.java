rxBus.toObservable()
    .ofType(Events.IncomingMsg.class)
    // I'm making a big assumption that getMessage() is a thing here.
    .map(new Func1<Events.IncomingMsg, JSONObject>() {

        @Override
        public JSONObject call(final Events.IncomingMsg event) {
            return event.getMessage();
        }

    })
    .subscribe(new Action1<JSONObject>() {

        @Override
        public void call(final JSONObject message) {
            // Do something with message here.
        }

    });