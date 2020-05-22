TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
PhoneStateListener listener = new PhoneStateListener() {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            String stateString = "N/A";
            switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                stateString = "Idle";
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                stateString = "Off Hook";
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                stateString = "Ringing";
                break;
            }
        }
    };

    // Register the listener with the telephony manager
    telephonyManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);