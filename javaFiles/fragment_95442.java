public class MusicService extends Service {

    public static MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        mp = new MediaPlayer();     
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {  
    String action = intent.getAction();
    if (action.equals(ACTION_PLAY))
        processPlayRequest();
    return START_STICKY;
}