scrollPane.addEventFilter(SwipeEvent.SWIPE_DOWN,
            new EventHandler<SwipeEvent>() {

                public void handle(SwipeEvent event) {

                    vValueProperty.set(vValueProperty.get() - steps);

                    event.consume();

                }
            });