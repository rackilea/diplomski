WebEngine webEngine = webView.getEngine();
Worker worker = webEngine.getLoadWorker();
worker.stateProperty().addListener((Observable o) -> {
    if (worker.getState() == Worker.State.SUCCEEDED) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WritableImage image = webView.snapshot(
                    new SnapshotParameters(), new WritableImage(800, 400));
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
                try {
                    ImageIO.write(bufferedImage, "png", new File("image.png"));
                } catch (IOException va) {
                    va.printStackTrace();
                }
            }
        });
    }
});