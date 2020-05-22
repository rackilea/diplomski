@Override
protected void onCreate(final Bundle savedInstanceState) {
 psListener = new MyPhoneStateListener();
 telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
 telephonyManager.listen(psListener,PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
}