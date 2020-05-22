class MyTimerTask extends TimerTask
{
     public void run()
     {
          System.out.println(setInterval());
     }
}

TimerTask task = new MyTimerTask();
timer.scheduleAtFixedRate(task, delay, period);