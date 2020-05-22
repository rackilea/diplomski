Label timeLabel = new Label();
timeLabel.textProperty().bind(
    Bindings.createStringBinding(() -> {
            Duration time = mp.getCurrentTime();
            return String.format("%4d:%02d:%04.1f",
                (int) time.toHours(),
                (int) time.toMinutes() % 60,
                time.toSeconds() % 3600);
        },
        mp.currentTimeProperty()));