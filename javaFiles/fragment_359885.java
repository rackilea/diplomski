label.textProperty().bind(Bindings.createStringBinding(() -> {
    if (b.isPressed()) {
         return "test pressed";
    } else {
         return "test";
    }
}, b.pressedProperty());