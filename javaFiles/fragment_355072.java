crossfade.setOnFinished(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        mp1.stop();
    }
});