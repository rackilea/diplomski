public class SmsResultReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ...

        String uriString = data.getStringExtra("uri");
        Uri uri = Uri.parse(uriString);

        // Query as shown above in the ContentObserver
        ...
    }
}