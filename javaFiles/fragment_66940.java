public class One extends Service {
public static final long NOTIFY_INTERVAL = 10 * 1000;
private Handler handler = new Handler();
private Timer timer = null;

@Override
public IBinder onBind(Intent intent) {
    return null;
}

@Override
public void onCreate() 
{
    if (timer != null) 
    {
        timer.cancel();
    } else
    {
        timer = new Timer();
    }
    timer.scheduleAtFixedRate(new DisplayTime(), 0, NOTIFY_INTERVAL);
}

class DisplayTime extends TimerTask 
{

    @Override
    public void run() {
        handler.post(new Runnable() {

            @Override
            public void run() {
                recall();
                Toast.makeText(getApplicationContext(), "run", Toast.LENGTH_SHORT).show();
            }

        });
    } 
 public void recall() {

      // Write here Async Task Method......
    }
 }           
  @Override
  public void onDestroy()
  {
    super.onDestroy();
    Toast.makeText(getApplicationContext(), "des", Toast.LENGTH_SHORT).show();
  }
}