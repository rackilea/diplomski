ObjectProperty<Upload> upload = new SimpleObjectProperty();
ProgressListener progressListener = (ProgressEvent progressEvent) -> {
if (upload.get() == null) {
    return;
}
Platform.runLater(() -> {
    directory.setProgressIndicator(upload.get().getProgress().getPercentTransferred() / 100.0d);
    MainController.directoryList.set(MainController.directoryList.indexOf(directory), directory);
});
if (progressEvent.getEventType() == ProgressEventType.TRANSFER_COMPLETED_EVENT) {
    Platform.runLater(() -> {
        directory.setProgressIndicator(1.0d);
        MainController.directoryList.set(MainController.directoryList.indexOf(directory), directory);
    });
} else if (progressEvent.getEventType() == ProgressEventType.TRANSFER_FAILED_EVENT) {
    try {
        AmazonClientException ex = upload.get().waitForException();
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Uploading File");
            alert.setContentText("Unable to upload file to Amazon S3:" + ex.getMessage());
            alert.showAndWait();
        });
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}
};
//</editor-fold>
upload.set(s3Service.uploadFile(file, file.length(), file.getName(), progressListener));