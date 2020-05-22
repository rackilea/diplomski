public class SampleOverlayService extends OverlayService {

private int totalCount = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        totalCount = intent.getIntExtra("tot", 0);
        return super.onStartCommand(intent, flags, startId);
    }

}