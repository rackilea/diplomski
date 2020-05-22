final BooleanProperty spacePressed = new SimpleBooleanProperty(false);
final BooleanProperty rightPressed = new SimpleBooleanProperty(false);
final BooleanBinding spaceAndRightPressed = spacePressed.and(rightPressed);

// How to respond to both keys pressed together:
spaceAndRightPressed.addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<Boolean> obs, Boolean werePressed, Boolean arePressed) {
        System.out.println("Space and right pressed together");
    }
});

// Wire up properties to key events:
scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent ke) {
        if (ke.getCode() == KeyCode.SPACE) {
            spacePressed.set(true);
        } else if (ke.getCode() == KeyCode.RIGHT) {
            rightPressed.set(true);
        }
    }
});

scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent ke) {
        if (ke.getCode() == KeyCode.SPACE) {
            spacePressed.set(false);
        } else if (ke.getCode() == KeyCode.RIGHT) {
            rightPressed.set(false);
        }
    }
});