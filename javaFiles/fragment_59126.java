Timer t = new Timer( );
t.scheduleAtFixedRate(new TimerTask() {

    @Override
    public void run() {
      System.out.println("Hey");

    }
}, 1000,5000);