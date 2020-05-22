public class PhoneStateManager extends PhoneStateListener{

public static Boolean usingPhone = false;
private MainActivity mainactivity;
private String mIncomingNumber;

public PhoneStateManager(MainActivity main){
    mainactivity = main;
}

@Override
public void onCallStateChanged(int state, String incomingNumber) {
    switch (state) {
    case TelephonyManager.CALL_STATE_IDLE:
        Log.d("DEBUG", "IDLE");
        if(usingPhone){
            Log.d("DEBUG", "number (PSM): " + mIncomingNumber);
            mainactivity.askQuestion(mIncomingNumber);
        }
        usingPhone = false;
        break;
    case TelephonyManager.CALL_STATE_OFFHOOK:
        Log.d("DEBUG", "OFFHOOK");
        usingPhone = true;
        break;
    case TelephonyManager.CALL_STATE_RINGING:
        Log.d("DEBUG", "RINGING");
        mIncomingNumber = incomingNumber;
        usingPhone = false;
        break;
    }
}