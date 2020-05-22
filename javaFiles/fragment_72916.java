ui.access(new Runnable() {
    @Override
    public void run() {
        textArea.setValue(newValue);
        ui.push();
    }
});