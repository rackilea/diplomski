public class yourBluetoothService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        // init code
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.v("BluetoothService", "service started");

        new Handler().post(new Runnable() {
            @Override void run() {
                //your code to start service
            }      
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}