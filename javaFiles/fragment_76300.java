private void startTimer(TimeCard card) {
    new Logger(TimeCardButton.class).debug("Play button was pressed");
    if (!card.isTimeStarted()) {
        card.setTimeStarted(true);
        notifyDataSetChanged(); // Call notifyDataSetChanged instead here.
    } else if(card.isTimerPaused() && card.isTimeStarted()) {
        TimerTask.notifyUpdate();
        card.setTimerPaused(false);
        notifyDataSetChanged(); // Call notifyDataSetChanged instead here.
    }
}