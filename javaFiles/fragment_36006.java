package com.biapps.makin_biscuits;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Jake on 3/21/2016.
 */

public class IncomingCallReceiver extends BroadcastReceiver {

private static final String TAG = "MyListener";
    private Context mContext;
    private Intent mIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        mIntent = intent;
        TelephonyManager tm = (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
        int events = PhoneStateListener.LISTEN_CALL_STATE;

        tm.listen(phoneStateListener, events);
    }

    int previousState=TelephonyManager.CALL_STATE_OFFHOOK;
    private final PhoneStateListener phoneStateListener = new PhoneStateListener() {
        @Override

        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);

            int Call_State_Ringing = TelephonyManager.CALL_STATE_RINGING;
            int Call_State_OffHook = TelephonyManager.CALL_STATE_OFFHOOK;
            if (Call_State_Ringing == state && Call_State_OffHook == previousState){
            Log.i(TAG, "number: " + incomingNumber + "");
            Toast.makeText(mContext,"Incoming Call: " + incomingNumber + "",Toast.LENGTH_LONG).show();
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:

                        SmsManager smsManager =     SmsManager.getDefault();
                        smsManager.sendTextMessage(incomingNumber, null, "I'm busy bruh", null, null);
                    TelephonyManager tm = (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
                    tm.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE);

            }

                   }
            previousState = state;
    }
};}