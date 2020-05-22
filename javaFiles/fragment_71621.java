import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class StopApp {
Timer timer = new Timer();
TimerTask StopApp = new TimerTask() {
    @Override
    public void run() {
        System.exit(0);
    }
};
public StopApp() {

//timer.schedule(exitApp, getDateDiff(new Date("get the actual time"), new Date("get the time you want to stop your app"), TimeUnit.SECONDS));
    //Example
    timer.schedule(StopApp, new Date(System.currentTimeMillis()+2*1000));//Exits after 2 sec of starting the app

while(true)

    System.out.println("The App still turn");
}

public static Date getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
    long diffInMillies = date2.getTime() - date1.getTime();
    Date date=new Date(diffInMillies);

    return date;//timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
}

public static void main(String[] args) {

    new StopApp();

}
}