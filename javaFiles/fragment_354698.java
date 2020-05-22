private BooleanProperty upPressed = new SimpleBooleanProperty();
private BooleanProperty rightPressed = new SimpleBooleanProperty();

private BooleanBinding anyPressed = upPressed.or(rightPressed);

// ...

getScene().setOnKeyPressed(e -> {
    if (e.getCode() == KeyCode.UP) {
        upPressed.set(true);
    }
    if (e.getCode() == KeyCode.RIGHT) {
        rightPressed.set(true);
    }
});

getScene().setOnKeyReleased(e -> {
    if (e.getCode() == KeyCode.UP) {
        upPressed.set(false);
    }
    if (e.getCode() == KeyCode.RIGHT) {
        rightPressed.set(false);
    }
});