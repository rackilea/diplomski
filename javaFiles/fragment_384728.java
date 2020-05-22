public class MainActivity extends Activity
    implements SmsObserver.OnSmsSentListener {
    ...

    public void onClick(View v) {
        String address = "+1 234 567 8900";
        String body = "HI Greg! ";

        new SmsObserver(this, address, body).start();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(address, null, body, null, null);
    }

    @Override
    public void onSmsSent(int threadId) {
        // Here's the thread ID.
    }
}