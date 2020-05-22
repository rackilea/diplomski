Timer timer = new Timer ();
TimerTask myTask = new TimerTask () {
    @Override
    public void run () {
        // call your method here
    }
};

// Schedule the task. Start it when your date is reached!
timer.schedule(myTask, yourDate);