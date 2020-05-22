Timer timer = new Timer();
int begin = 0;
int timeInterval = 1000;
timer.schedule(new TimerTask() {
  int counter = 0;
   @Override
   public void run() {
       //call the method
       counter++;
       if (counter >= 20){
         timer.cancel();
       }
   }
}, begin, timeInterval);