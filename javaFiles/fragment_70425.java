Platform.runLater(new Runnable() {
    @Override
    public void run() {
        Pane title = (Pane) titledPane.lookup(".title");
        if (title != null) {
            title.setVisible(false);
        }
    }
});