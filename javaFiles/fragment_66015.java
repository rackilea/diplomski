void pauseTimerForDuration(AnimationTimer timer, Duration duration) {
    PauseTransition pt = new PauseTransition(duration);
    pt.setOnFinished(event -> timer.start());

    timer.stop();
    pt.play();
}