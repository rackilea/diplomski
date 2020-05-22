boolean currentlyPlaying = false;
node.setOnMouseClicked(event -> {
    if (!currentlyPlaying)
        update();
});
public void update() {
    Animation animation = new RotateTransition(Duration.millis(100), this);
    animation.setByAngle(90);
    animation.play();
    currentlyPlaying = true;
    animation.setOnFinished(event -> currentlyPlaying = false;);
    tile.rotate();
}