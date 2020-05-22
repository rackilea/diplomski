public class CallRecordService extends Service {
    final SharedPreferences mSharedPreference= 
    @Override
    public void onCreate() {
      PreferenceManager.getDefaultSharedPreferences(getApplicationContext()); // You can pass context here
        serverURL =(mSharedPreference.getString("autoSave", ""));
    }
}