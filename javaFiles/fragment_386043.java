public void setFile(File file) {
    if (file == null)
        return;
    videoFile = file;
    media = new Media(videoFile.toURI().toString());
    mediaPlayer = new MediaPlayer(media);
    mediaView = new MediaView(mediaPlayer);
    width = mediaView.fitWidthProperty();
    height = mediaView.fitHeightProperty();
}