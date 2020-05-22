final SmsManager sms = SmsManager.getDefault();
private static SmsListener mListener;
@Override
public void onReceive(Context context, Intent intent) {
    final Bundle bundle = intent.getExtras();
    try {
        if (bundle != null) {
            final Object[] pdusObj = (Object[]) bundle.get("pdus");
            for (int i = 0; i < pdusObj.length; i++) {
                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                String senderNum = currentMessage.getDisplayOriginatingAddress();
                String message = currentMessage.getDisplayMessageBody();
                if (message.equalsIgnoreCase("FIRE DETECTED") ){
                    mListener.messageReceived(message); //add this
                    Log.i("SmsReceived", "senderNum: "+ senderNum + "; message: " + message);
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, message, duration);
                    toast.show();
                }
            }
        }
    } catch (Exception e) {
        Log.e("SmsReceiver", "Exception smsReceiver" +e);
    }
}
public static void bindListener(SmsListener listener) {
        mListener = listener;
    }