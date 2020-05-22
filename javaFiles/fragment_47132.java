ComponentName devAdminReceiver; // this would have been declared in your class body
// then in your onCreate
    mDPM = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
    devAdminReceiver = new ComponentName(context, deviceAdminReceiver.class);
//then in your onResume

boolean admin = mDPM.isAdminActive(devAdminReceiver);
if (admin)
    mDPM.lockNow();
else Log.i(tag,"Not an admin");