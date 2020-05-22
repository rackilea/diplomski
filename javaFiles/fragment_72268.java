Task<Boolean> checkForUpdateTask = new Task<Boolean>() {
    @Override
    public Boolean call() throws Exception {
        // check for updates...
        if (/* updates available */) {
            return true ;
        } else {
            return false ;
        }
    }
};
checkForUpdateTask.setOnSucceeded(e -> {
    if (checkForUpdateTask.getValue() && shouldApplyUpdates()) {
        // apply updates...
    } else {
        // proceed....
    }
});
checkForUpdateTask.setOnFailed(e -> {
    checkForUpdateTask.getException().printStackTrace();
});
new Thread(checkForUpdateTask).start();