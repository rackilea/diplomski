scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ESCAPE)) {
            stage.close();
        }
    }
});