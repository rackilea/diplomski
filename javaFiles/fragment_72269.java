Task<Void> checkForUpdateTask = new Task<Void>() {
    @Override
    public Void call() throws Exception {
        // check for updates...
        if (/* updates available */) {
            FutureTask<Boolean> checkUser = new FutureTask<Boolean>(() -> shouldApplyUpdates());
            Platform.runLater(checkUser);

            // checkUser.get() will block until it returns a value...
            if (checkUser.get()) {
                // apply updates...
            }
        }
        return null ;
    }
};
new Thread(checkForUpdateTask).start();