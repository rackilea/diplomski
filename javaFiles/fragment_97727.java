if (value == 0 && actionListener != null) {
    isRunning = false;
    valueTimer.stop();
    actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "counterFinished"));
    blinkTimer.stop();
} else if (value < maxValue / 2 && !blinkTimer.isRunning()) {
    blinkTimer.start();
}