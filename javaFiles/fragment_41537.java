public class CallRecordService extends Service {
    final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    // Call this in your onCreate() section .
    @Override
    public void onCreate() {
        serverURL =(mSharedPreference.getString("autoSave", ""));
    }
}