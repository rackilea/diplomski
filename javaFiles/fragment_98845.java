public void show(ImageView view, Image[] gifs, Duration displayDuration) {
    Timeline timeline = new Timeline();

    Duration totalDelay = Duration.ZERO;
    for (Image gif : gifs) {
        KeyFrame frame = new KeyFrame(totalDelay, e -> view.setImage(gif));
        timeline.getFrames().add(frame);
        totalDelay = totalDelay.add(displayDuration);
    }
    timeline.getFrames().add(new KeyFrame(totalDelay, e -> view.setImage(null));

   timeline.play();
}