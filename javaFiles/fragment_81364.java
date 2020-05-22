Timer timer = new Timer();
    timer.schedule(new MyTask(), 60 * 1000);


class MyTask extends TimerTask {
    public void run() {
       Date date = new Date();
       if(date.compareTo(midnight) == 0) {
      //Download code
     }
    }