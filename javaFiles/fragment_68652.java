public void stopAndSaveChronometer(View v) {
  if (running) {
    chronometer.stop();
    running = false;
    time = SystemClock.elapsedRealtime() - chronometer.getBase();
    h = (int) (time / 3600000);
    m = (int) (time - h * 3600000) / 60000;
    s = (int) (time - h * 3600000 - m * 60000) / 1000;

    displayTheTime = String.valueOf(h) + " hours, "
            + String.valueOf(m) + " minutes, "
            + String.valueOf(s) + " seconds";

    // display the times in the Textview
    showMyTime.setText(displayTheTime);

  }
}