Platform.runLater(new Runnable() {
    @Override
    public void run() {
        getStage().getScene().setCursor(Cursor.WAIT);
    }
});

// Do some stuff

Platform.runLater(new Runnable() {
    @Override
    public void run() {
        getStage().getScene().setCursor(Cursor.DEFAULT);
    }
});