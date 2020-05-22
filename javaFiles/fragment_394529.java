private void runOnInterval(long millisUntilFinished) {
    if (millisUntilFinished < startTime) {
        playSound();
        startTime -= interval;
    }
}