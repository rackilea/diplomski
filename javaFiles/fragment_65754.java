stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent e) {
        // SHOW A DIALOG HERE
        Platform.exit();
        System.exit(0);
    }
});