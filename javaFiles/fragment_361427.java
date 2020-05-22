new Thread(() -> {
    for (File image : images) {
       uploadFileToS3Bucket(image, "uploadingLocation");
       Platform.runLater(() -> monitor.print("Uploading image"+image.getName()+"\n"));
    }
}).start();