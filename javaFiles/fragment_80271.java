boolean stop;
public void Timer() 
{
    Timer timer = new Timer(); 
    long interval = (1000) ;
    timer.schedule( new TimerTask() 
    {
        public void run() 
        {
            if condition is met{
                execute
            }
            else if(stop == true){
                timer.cancel();
            }       
        }
    }, 0, interval);         
}

.
.
.

stop = true;
try {
    Thread.sleep(2000);
} catch (InterruptedException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
}
stop = false;
Timer1();