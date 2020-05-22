public class MyService extends Service {

    @Override
    public int onStartCommand(final Intent intent, final int flags,
                      final int startId) {
        // parse the intent and run your things
        return START_NOT_STICKY;
    }
}