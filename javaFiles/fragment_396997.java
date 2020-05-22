public class MyService extends Service {
private Handler mTimer = new Handler();
private Runnable mTask = new Runnable() {
@Override
public void run() {
//DO SOMETHING HERE
mTimer.postDelayed(this, interval*1000L);
}
};

private int interval = 60; // 60 seconds

public void onCreate() {
mTimer.postDelayed(mTask, interval*1000L); //start the timer for the first time
}

public void onDestroy() {
if(mTimer != null) {
mTimer.removeCallbacks(mTask); //cancel the timer
}
}
}