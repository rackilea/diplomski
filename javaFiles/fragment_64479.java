Timer timer = new Timer ();
TimerTask sometask = new TimerTask () {
    @Override
    public void run () {
        // code
    }
};

timer.schedule (sometask, 0l, 1000*60*5);