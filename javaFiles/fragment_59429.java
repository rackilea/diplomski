gc.clearRect(0, 0, getWidth(), getHeight());
AnimationTimer waitForFrameRender = new AnimationTimer() {
    private int frameCount = 0 ;
    @Override
    public void handle(long timestamp) {
        frameCount++ ;
        if (frameCount >= 2) {
            stop();
            // now do screen capture...
        }
    }
};
waitForFrameRender.start();