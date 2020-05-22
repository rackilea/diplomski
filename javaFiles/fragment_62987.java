notificationPanel.show();
 Timer timer = new Timer() {
     @Override
     public void run() {
         notificationPanel.hide();
     }
 };
 timer.schedule(10000);