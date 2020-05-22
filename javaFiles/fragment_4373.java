import java.util.Timer;
 import java.util.TimerTask;
 import java.util.concurrent.TimeUnit;
 class RepeatableTask extends TimerTask{
    int repeats;
    Timer time;
    public RepeatableTask(int repeats){
        this.repeats=repeats;
    }
    void init(){
        time = new Timer();
        time.schedule(this,0,TimeUnit.MINUTES.toMillis(delayInMinutes));
    }
    void stop(){
        time.cancel();
    }
    void run(){
        if(repeats == 0){stop();}
        new Thread->{
            //task
        }
        repeats--;
    }
}

//usage
RepeatableTask taskObject = new RepeatableTask(5);
taskObject.init();