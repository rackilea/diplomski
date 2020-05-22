public class PhoneCallReceiver extends BroadcastReceiver {





@Override
public void onReceive(Context context, Intent intent) {

    String state= intent.getStringExtra(TelephonyManager.EXTRA_STATE);


    if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {



    context.sendBroadcast(new Intent("PHONE_RING"));

    }

}