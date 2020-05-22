Timer timer; 
MyTimerTask timerTask; 

timer = new Timer(); 
timerTask = new MyTimerTask();
timer.schedule ( timerTask, startingInterval, repeatingInterval );

private class MyTimerTask extends TimerTask 
{
     public void run()
     { 
        ...
        // Repetitive Activity goes here
     } 
}