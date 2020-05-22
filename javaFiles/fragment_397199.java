public class Settings extends PreferenceActivity{

    CheckBoxPreference cb1;
    CheckBoxPreference cb2;
    CheckBoxPreference cb3;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(R.xml.preferences);

        cb1 = (CheckBoxPreference) findPreference("CheckBox1");
        cb2 = (CheckBoxPreference) findPreference("CheckBox2");
        cb3 = (CheckBoxPreference) findPreference("CheckBox3");
        cb1.setOnPreferenceChangeListener(new Listener());
        cb2.setOnPreferenceChangeListener(new Listener());
        cb3.setOnPreferenceChangeListener(new Listener());

    }

    private class Listener implements OnPreferenceChangeListener {

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            if((Boolean) newValue) 
                removeOthers(preference.getKey());
            return true;
        }
    }

    private void removeOthers(String key) {
        if(key.equals("CheckBox1")) {
            cb2.setChecked(false);
            cb3.setChecked(false);
        }
        else if(key.equals("CheckBox2")) {
            cb1.setChecked(false);
            cb3.setChecked(false);
        }
        else if(key.equals("CheckBox3")) {
            cb1.setChecked(false);
            cb2.setChecked(false);
        }
    }
}