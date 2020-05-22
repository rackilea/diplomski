public class MyMessagingService extends FirebaseMessagingService {
private LocalBroadcastManager broadcaster;

@Override
public void onCreate() {
    broadcaster = LocalBroadcastManager.getInstance(this);
}


@Override
public void onMessageReceived(RemoteMessage remoteMessage) {
    super.onMessageReceived(remoteMessage);
    Log.d("message here", "message here " + remoteMessage.getData().toString());
    String value = remoteMessage.getData().get("msg");
    Log.d("value here", "value here" + " " + value);
    if (value.equalsIgnoreCase("hello")) {
        Intent intent = new Intent("custom-listener");
        broadcaster.sendBroadcast(intent)
    }
}