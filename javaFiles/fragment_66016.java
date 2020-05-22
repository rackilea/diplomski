Timeline createPauseTimerTimeline(AnimationTimer timer, Duration duration) {
    return new Timeline(
            new KeyFrame(Duration.ZERO, event -> timer.stop()),
            new KeyFrame(duration, event -> timer.play())
    );
}