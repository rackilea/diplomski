public class SMSReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Bundle myBundle = intent.getExtras();
        SmsMessage[] messages;

        if (myBundle != null) {

            Toast toast = Toast.makeText(context, "SMS Message Received!",duration);
        }
    }
}