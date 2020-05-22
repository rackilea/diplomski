double delta = .. ;

AnimationTimer timer = new AnimationTimer() {
    @Override
    public void handle(long timestamp) {
        if (upPressed.get()) {
            rect.setY(rect.getY()-delta);
            rect.setHeight(rect.getHeight() + delta);
        }
        if (rightPressed.get()) {
            rect.setWidth(rect.getWidth() + delta);
        }
    }
};

anyPressed.addListener((obs, wasPressed, isNowPressed) -> {
    if (isNowPressed) {
        timer.start();
    } else {
        timer.stop();
    }
});