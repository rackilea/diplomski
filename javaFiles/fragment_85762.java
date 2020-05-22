// define task 
TimerTask = tt new TimerTask()
{
    @Override
    public void run()
    {
        ...
    }
};


// schedule 
timer.scheduleAtFixedRate(tt,int,int);

// run as any other method :) 
tt.run();