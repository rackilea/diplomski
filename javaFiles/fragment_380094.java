SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

    protected void DialogBox() {
        box = new AlertDialog.Builder(this);
        box.setTitle("Reject incoming calls?").
                setMessage("On activation, your phone will reject all incoming calls").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                         preferences.edit().putBoolean(PREF_REJECT_CALLS, true).commit();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                 preferences.edit().putBoolean(PREF_REJECT_CALLS, false).commit();                
                 dialog.cancel();
            }
        });
        final AlertDialog alert = box.create();
        alert.show();

    }



public class RejectCall extends BroadcastReceiver {

public void onReceive(Context context, Intent intent) {

    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

    // If the value in preferences is false, do not reject the calls
    if(!preferences.getBoolean(PREF_REJECT_CALLS, false)){
       return;
    }

    Log.i("RejectClass", "Triggered");
    ITelephony telephonyService;
    TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    try {
        Class c = Class.forName(tm.getClass().getName());
        Method m = c.getDeclaredMethod("getITelephony");
        m.setAccessible(true);
        telephonyService = (ITelephony) m.invoke(tm);
        //telephonyService.silenceRinger();
        telephonyService.endCall();
    } catch (Exception e) {
        e.printStackTrace();
    }

}