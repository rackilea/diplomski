//The task which you want to execute
private static class MyTimeTask extends TimerTask
{

    public void run()
    {
        //write your code here
    }
}

public static void main(String[] args) {

    //the Date and time at which you want to execute
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = dateFormatter .parse("2012-07-06 13:05:45");

    //Now create the time and schedule it
    Timer timer = new Timer();

    //Use this if you want to execute it once
    timer.schedule(new MyTimeTask(), date);

    //Use this if you want to execute it repeatedly
    //int period = 10000;//10secs
    //timer.schedule(new MyTimeTask(), date, period );
}