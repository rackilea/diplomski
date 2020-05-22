int initialDelay = 1000; //first update in miliseconds
int period = 5000;      //nexts updates in miliseconds       

Timer timer = new Timer();
TimerTask task = new TimerTask() {
  public void run() {
      Message msg = new Message();
      mHandler.sendMessage(msg);
  }
};
timer.scheduleAtFixedRate(task, initialDelay, period);