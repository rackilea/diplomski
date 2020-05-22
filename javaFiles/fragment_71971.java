mediaPlayer.addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
    @Override
    public void positionChanged(MediaPlayer mediaPlayer, float newPosition) {
        timeSlider.setValue(newPosition);
    }
});

timeSlider.valueProperty().addListener((obs, oldval, newval) -> mediaPlayer.setPosition(newval));