TimerTask task = new TimerTask()
{
    int seconds = 8;
    int i = 0;
    @Override
    public void run()
    {
       i++;

       if(i % seconds == 0)
           System.out.println("Timer action!");
       else
           System.out.println("Time left:" + (seconds - (i %seconds)) );
    }
};

Timer timer = new Timer();
timer.schedule(task, 0, 1000);