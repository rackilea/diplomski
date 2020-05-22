@FXML private Label label;

private FadeTransition fadeIn = new FadeTransition(
    Duration.millis(3000)
);

public void initialize() {
    fadeIn.setNode(label);

    fadeIn.setFromValue(0.0);
    fadeIn.setToValue(1.0);
    fadeIn.setCycleCount(1);
    fadeIn.setAutoReverse(false);
}

@FXML
private void handleButtonAction(ActionEvent event) {
    if (!label.isVisible()) {
        label.setVisible(true);
        fadeIn.playFromStart();
    }
}