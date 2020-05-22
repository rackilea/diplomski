Timer timer = new Timer ();
TimerTask t = new TimerTask () {
    @Override
    public void run () {
        // some code
    }
};

timer.schedule (t, 0l, 1000*60*60*24);