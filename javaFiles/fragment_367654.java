static private void showAndBlock(Dialog dialog) {
    if (Platform.isFxApplicationThread()) {
        dialog.showAndWait();
    } else {
        CountDownLatch lock = new CountDownLatch(1);
        Platform.runLater(() -> {
            dialog.showAndWait();
            lock.countDown();
        });
        try {
            lock.await();
        } catch (InterruptedException e) {
            // Just in case you call yourTherad.interrupt(),
            // the thread will be joined forcibly through here.
        }
    }
}