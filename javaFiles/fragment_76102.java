else if (flag)
{
    startStopButton.setText("START TIMER");
    timer.stop();
    flag = false;
    counter = 0;
    changingLabel.setText("" + counter);
}