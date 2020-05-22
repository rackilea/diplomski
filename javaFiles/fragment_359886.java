StringProperty text = new SimpleStringProperty("test");
label.textProperty().bind(Bindings.createStringBinding(() -> {
    if (b.isPressed)() {
        return text.get() + " pressed" ;
    } else {
        return text.get();
    }
}, text, b.pressedProperty());