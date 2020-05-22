case TelephonyManager.CALL_STATE_RINGING: // incoming call
{
    for (int i = 0; i < forbiddenNumber.size; i++) {
        if (incomingNumber.equals(forbiddenNumber[i])) {
            // read the airplane mode setting
            boolean isEnabled = Settings.System.getInt(
                    getContentResolver(),
                    Settings.System.AIRPLANE_MODE_ON, 0) == 1;

            // toggle airplane mode
            Settings.System.putInt(getContentResolver(),
                    Settings.System.AIRPLANE_MODE_ON, isEnabled ? 0
                            : 1);

            // Post an intent to reload
            Intent intent = new Intent(
                    Intent.ACTION_AIRPLANE_MODE_CHANGED);
            intent.putExtra("state", !isEnabled);
            sendBroadcast(intent);

        }
    }