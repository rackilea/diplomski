TextArea ta = new TextArea();
ta.setOnKeyPressed(new EventHandler<KeyEvent>() {

    @Override
    public void handle(KeyEvent event) {
        if ((event.getCode() == KeyCode.Z || event.getCode() == KeyCode.Y)
            && event.isShortcutDown()) {
            event.consume();
        }

    }
});