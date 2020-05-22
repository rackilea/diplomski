if (Utils.fileIsImage(file) && !file.isDirectory()) {
    ImageView view = new ImageView(new Image("file:" + file, 72, 72, false, true));
    views.add(view);

    Platform.runLater(new Runnable() {
        @Override
        public void run() {
            imageList.getChildren().add(view);
        }
    });
}