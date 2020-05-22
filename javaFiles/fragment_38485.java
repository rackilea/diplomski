String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
if (TelephonyManager.EXTRA_STATE_RINGING.equals(state))
{
    String phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
    // call your asynctask ...
}