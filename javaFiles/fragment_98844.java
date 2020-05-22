public void show(ImageView currentGif, Image[] gifs) {
    for (int i = 0; i<gifs.length; i++) {
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, e -> { currentGif.setImage(gifs[i]); }),
            new KeyFrame(Duration.seconds(2), e -> { currentGif.setImage(null); })
        );
        timeline.play();
    }

}