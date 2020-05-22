spinBtn.setOnAction(e -> {
    field.setDisabled(false);
    PauseTransition pt = new PauseTransition(Duration.seconds(10));
    pt.setOnFinished(ev -> {
        field.setDisabled(true);
    });
    pt.play();
});