TimerTask tt = new TimerTask() {
    public void run()
    {
      //your current ActionEvent
    }
}

Timer t = new Timer("My Timer");
t.schedule(tt, new Date(wheneverTheFirstOneIs), 1000*60);