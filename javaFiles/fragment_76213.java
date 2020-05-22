private void processingEvent01() {
    // some long-running process here...

    Platform.runLater(() -> {
        // update UI here....
    });

    // some other long-running process here (perhaps)
}