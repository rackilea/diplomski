PauseTransition delay = new PauseTransition(Duration.seconds(7));
delay.setOnFinished(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        // do whatever you needed to do after the seven second pause
    }
});
delay.play();