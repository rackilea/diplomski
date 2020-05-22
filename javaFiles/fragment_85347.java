Button startButton = new Button();
startButton.textProperty().bind(Bindings.
    when(mainApp.getTestService().runningProperty()).
    then("Pause").
    otherwise("Start"));
startButton.setOnAction(e -> {
    if (mainApp.getTestService().isRunning()) {
        mainApp.getTestService().cancel();
    } else {
        mainApp.getTestService().restart();
    }
});