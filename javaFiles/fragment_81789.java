public MPButtonSkin(ToggleButton control, String image) {
    super(control, new BehaviorBase<>(control, Collections.<KeyBinding> emptyList()));

    toggleButton = new ToggleButton();
    toggleButton.setText(control.getText());
    toggleButton.alignmentProperty().setValue(Pos.BOTTOM_LEFT);
    toggleButton.setStyle("-fx-background-color:transparent;");

    // ...
}