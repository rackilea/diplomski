TimerTask tt = new TimerTask(){
  long prev = System.currentTimeMillis();
  public void run(){
    long now = System.currentTimeMillis();
    for (Mass m : masses) {
      m.updatePosition(now-prev);
    }
    prev = now;
  }
}

new Timer(true).schedule(tt, 1000, 1000) ;