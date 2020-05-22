this.addAction(Actions.forever(Actions.sequence(
    Actions.run(new Runnable {
        @Override
        public void run() {
            stand();
        }
    }),
    Actions.delay(0.3f),
    Actions.run(new Runnable {
        @Override
        public void run() {
            blink();
        }
    });
)));