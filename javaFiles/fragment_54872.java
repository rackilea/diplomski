public void pressBtn() {
    if(!isXPressed) {
        Platform.runLater(() -> iv1.setVisible(true));
        isXPressed = true;
    }
}