public void continueTime(){
    long temp = Calendar.getInstance().getTimeInMillis();
    time.setText("Elapsed time is " + formatTime((long) (temp - start)));
}

private void timerContinue(){
    ActionListener timerAL = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            continueTime();
        }
    };

    //stop the timer if it is still running
    if (swTimer != null && swTimer.isRunning()) {
        swTimer.stop();
    }

    swTimer = new Timer(1000, timerAL);
    swTimer.setInitialDelay(0);
    swTimer.start();
}