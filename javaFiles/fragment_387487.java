TimerTask timerTask = new TimerTask() 
{ 
    public void run()  
    { 
         .... //Whatever inside your loop will be executed every second
    } 
}; 

.... 

Timer timer = new Timer(); 
timer.scheduleAtFixedRate(timerTask, 0, 1000);