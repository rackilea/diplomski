public class SMSReceiver extends BroadcastReceiver {

public static final String NOTIFICATION = "receiver_sms";
@Override
public void onReceive(Context context, Intent intent) {

    Log.i("onReceive methode", "new SMS Comming");

    Bundle myBundle = intent.getExtras();

    SmsMessage[] messages = null;
    String strMessage = "", address = "";
    abortBroadcast();
    if (myBundle != null) {
        // get message in pdus format(protocol description unit)
        Object[] pdus = (Object[]) myBundle.get("pdus");
        // create an array of messages
        messages = new SmsMessage[pdus.length];
        Log.i("onReceive methode", "new SMS Comming");
        for (int i = 0; i < messages.length; i++) {
            // Create an SmsMessage from a raw PDU.
            messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            // get the originating address (sender) of this SMS message in
            // String form or null if unavailable
            address = messages[i].getOriginatingAddress();

            // get the message body as a String, if it exists and is text
            // based.
            strMessage += messages[i].getMessageBody();
            strMessage += "\n";
        }

        // show message in a Toast
    }
        // this is what you need
        Intent broadcast = new Intent(NOTIFICATION);
        broadcast.putExtra("data", strMessage);
        LocalBroadcastManager.getInstance(context).sendBroadcast(broadcast);

}