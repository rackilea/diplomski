class ContainingClass {
  void myMethod() {
    for(int i = 0; i < 10; ++i) {
      outerTimer = new MyAnonymousTimer();

      outerTimer.run();
      outerTimer.scheduleRepeating(tmptimerDuration);
    }
  }
}

class MyAnonymousTimer extends Timer {
  @Override
  public void run() {        
    if(stopTimer) {
      cancel();
      break; // break cannot be used outside of a loop or a switch
    }

   repeatLoop();
  }         
}