switch(state) {
        case TelephonyManager.CALL_STATE_IDLE:
                Log.d("Call","Outgoing Call finished");
        break;
        case TelephonyManager.CALL_STATE_OFFHOOK:
                Log.d("Call","Outgoing Call Starting");
        break;
    }