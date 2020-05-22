public class CustomService extends Service
{
private final IBinder mIBinder = new LocalBinder();

private Handler mHandler = null;

@Override
public void onCreate()
{
    super.onCreate();
}

@Override
public int onStartCommand(Intent intent, int flag, int startId)
{
    return START_STICKY;
}

@Override
public void onDestroy()
{
    if(mHandler != null)
    {
        mHandler = null;
    }
}

@Override
public IBinder onBind(Intent intent)
{
    return mIBinder;
}

public class LocalBinder extends Binder
{
    public CustomService getInstance()
    {
        return CustomService.this;
    }
}

public void setHandler(Handler handler)
{ 
   mHandler = handler;
}

}