@Override
public void onReceive(Context con, Intent intent)
 {

    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(); 
    prefs.edit().putBoolean("hasAppUpdated", true).apply();
}