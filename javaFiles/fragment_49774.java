ScrollPane scrollPane = new ScrollPane();
    final IntegerProperty vValueProperty = new SimpleIntegerProperty(0);
    final int steps = 5;

    scrollPane.vvalueProperty().bind(vValueProperty);

    scrollPane.setOnSwipeDown(new EventHandler<GestureEvent>() {

        public void handle(GestureEvent event) {
            // calculate the needed value here
            vValueProperty.set(vValueProperty.get() + steps);
        }
    });