timer.scheduleAtFixedRate(new TimerTask()
{
     public void run()
     {
          System.out.println(setInterval());
     }
}, delay, period);