Timer timer = new Timer();
     int start=10000; //millisecond 10 seconds=10000
     int delay=1000; // millisecond 1 second
     timer.schedule(new TimerTask()
       {
        public void run() {
            // what happens when the timer repeats
        }
      },start,delay);