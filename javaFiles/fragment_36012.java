Slider seekSlider = new Slider(0, 1, 0);
seekSlider.maxProperty().bind(
    Bindings.createDoubleBinding(
        () -> mp.getTotalDuration().toSeconds(),
        mp.totalDurationProperty()));

mp.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
    seekSlider.setValue(newValue.toSeconds());
});

seekSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
    mp.seek(Duration.seconds(newValue.doubleValue()));
});