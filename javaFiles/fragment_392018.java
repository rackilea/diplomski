public class SomePreference extends PreferenceActivity implements OnSharedPreferenceChangeListener{

protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.task_pref);


    SharedPreferences SP = PreferenceManager
            .getDefaultSharedPreferences(getBaseContext());


    // Register OnChangeListener
    SP.registerOnSharedPreferenceChangeListener(this);
}

@Override
public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
        String key) {
    // TODO Auto-generated method stub
    //Make sure the item changed was the list_preference 
    if(key.equals("")){
        String value = sharedPreferences.getString(key, "Double");

        Intent i = new Intent(this, Main.class);
        startActivity(i);
    }
}