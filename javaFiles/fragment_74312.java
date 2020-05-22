stage.setFullScreen(true);
stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent event) {
        //Handle
        event.consume();
    }
});
primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);