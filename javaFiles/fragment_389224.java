if(isRunning){
    chronometer.stop();

    long stoppedTime = SystemClock.elapsedRealtime() - chronometer.getBase();

    // Create the desired format
    SimpleDateFormat formatter = new SimpleDateFormat("mm:ss", Locale.getDefault());

    myTextView.setText(formatter.format(stoppedTime)); // Set the formatted time in the textview
}