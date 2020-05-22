TimerTask splashTask = new TimerTask() 
{
  public void run() {
    final UiApplication uia = UiApplication.getUiApplication();
    final Object eventLock = uia.getEventLock();
    synchronized(eventLock) {
       uia.pushScreen(new HomeNavigationScreen());
    }
  }
};

timer.schedule(splashTask, 3000);