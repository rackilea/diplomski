Platform.runLater(() -> {
    saveButton.setText("Saving...");
    Util.print("Saving...");
});


Thread saveIt = new Thread(new Runnable() {
    @Override public void run() {
        try {
            sleep(2000);
        } catch (Exception ex) {
            Util.print(ex);
        }
        Platform.runLater(() -> {
            saveButton.setText("Saved!");
            Util.print("Saved!");
        });
    }
});
saveIt.setDaemon(true);
saveIt.start();