public class MainActivity extends BroadcastReceiver {

public void onReceive(Context context, Intent intent) {

try {
           // TELEPHONY MANAGER class object to register one listner
            TelephonyManager tmgr = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);

            //Create Listner
            MyPhoneStateListener PhoneListener = new MyPhoneStateListener();

            // Register listener for LISTEN_CALL_STATE
            tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);

    } catch (Exception e) {
        Log.e("Phone Receive Error", " " + e);
    }

}

private class MyPhoneStateListener extends PhoneStateListener {
    public void onCallStateChanged(int state, String incomingNumber) {

        Log.d("MyPhoneListener",state+"   incoming no:"+incomingNumber);

        if (state == 1) {

            String msg = "New Phone Call Event. Incomming Number : "+incomingNumber;
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(pcontext, msg, duration);
            toast.show();

        }
    }
}