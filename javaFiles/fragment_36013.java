Label timeLabel = new Label();
Slider seekSlider = new Slider();

mp.setOnReady(() -> {
    timeLabel.textProperty().bind(
        Bindings.createStringBinding(() -> {
                Duration time = mp.getCurrentTime();
                return String.format("%4d:%02d:%04.1f",
                    (int) time.toHours(),
                    (int) time.toMinutes() % 60,
                    time.toSeconds() % 3600);
            },
            mp.currentTimeProperty()));

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
});