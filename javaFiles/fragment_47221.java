Window.addWindowClosingHandler(new Window.ClosingHandler() {
    @Override
    public void onWindowClosing(ClosingEvent event) {
        if (unsavedData) {
            event.setMessage("There is unsaved data. Do you really want to leave?");
        }
    }
});