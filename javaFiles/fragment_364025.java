// New timer for 10 minutes, starts after initialization
new MyCount(600000, 1000) 
{
    // Updates the text on your "scoreboard" every second
    public void onTick(long millisUntilFinished) 
    {
        Timer.setText("Time remaining: " + formatTime(millisUntilFinished));
    }

    public void onFinish() 
    {
        mTextField.setText("done!");
    }
}.start();