TimerTask task = new TimerTask()
{
     public void run()
     {
          System.out.println(setInterval());
     }
};

timer.scheduleAtFixedRate(task, delay, period);