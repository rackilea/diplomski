playButton.addListener(new InputListener() {
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        SoundManager.PlayButtonSound();
        return false;
    }
});