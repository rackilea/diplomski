TelephonyManager tm;
    private PhoneStateListener mPhoneListener = new PhoneStateListener() {
      public void onCallStateChanged(int state, String incomingNumber) {
       try {
        switch (state) {
        case TelephonyManager.CALL_STATE_RINGING:
         Toast.makeText(GameActivity.this, "CALL_STATE_RINGING", Toast.LENGTH_SHORT).show();

         //Your function to save state right here...
         stopTimer();
         break;
        case TelephonyManager.CALL_STATE_OFFHOOK:
         Toast.makeText(GameActivity.this, "CALL_STATE_OFFHOOK", Toast.LENGTH_SHORT).show();
         break;
        case TelephonyManager.CALL_STATE_IDLE:
         Toast.makeText(GameActivity.this, "CALL_STATE_IDLE", Toast.LENGTH_SHORT).show();
         break;
        default:
         Toast.makeText(GameActivity.this, "default", Toast.LENGTH_SHORT).show();
         Log.i("Default", "Unknown phone state=" + state);
        }
       } catch (Exception e) {
        Log.i("Exception", "PhoneStateListener() e = " + e);
       }
      }
     };