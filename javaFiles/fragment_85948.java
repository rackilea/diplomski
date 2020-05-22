public class Zing extends Service {
    public int onStartCommand(Intent intent, int flags, int startId) {
        // It'd be better call another method passing the Intent...
        Bundle extras = intent.getExtras();
        return START_STICKY;
    }
}