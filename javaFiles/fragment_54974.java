TimerTask splashTask = new TimerTask() 
{
  public void run() {
    final UiApplication uia = UiApplication.getUiApplication();
    uia.invokeLater(new Runnable() { 
      public void run() {
        uia.pushScreen(new HomeNavigationScreen());
     });
    }
  }
};

timer.schedule(splashTask, 3000);