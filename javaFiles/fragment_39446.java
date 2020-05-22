public class DemoEditPreferences extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{

private SharedPreferences demo_preferences;
private int preferencesToEdit;

@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    demo_preferences = getActivity().getSharedPreferences("demo_preference",
            0);

    preferencesToEdit = R.xml.demo_preferences;
    String preferenceName = getResources().getString(R.string.pref_sensor_key);

    PreferenceManager preferenceManager = getPreferenceManager();
    preferenceManager.setSharedPreferencesName(preferenceName);
    preferenceManager.setSharedPreferencesMode(0);

    getActivity().setTitle("Demo Preferences");

    addPreferencesFromResource(preferencesToEdit);

    Preference from_another_activity_p = (Preference) findPreference("passed_from_another_activity_key");

    if(getActivity().getIntent() != null) {

        from_another_activity_p.setSummary(getActivity().getIntent().getStringExtra("Passed"));
    }

    updateResult();

    for (int i = 0; i < getPreferenceScreen().getPreferenceCount(); i++) {
        initSummary(getPreferenceScreen().getPreference(i));
    }

}


@Override
public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    if(findPreference(key) != null) {

        if(findPreference(key).getKey().equals("x_key")) {

            updateResult();

        }else if(findPreference(key).getKey().equals("y_key")) {


            updateResult();

        }

        checkPrefValueValidity(findPreference(key));
        updatePrefSummary(findPreference(key));
    }

}

private void updateResult(){

    EditTextPreference x_p = (EditTextPreference) findPreference("x_key");
    EditTextPreference y_p = (EditTextPreference) findPreference("y_key");
    Preference result_p = (Preference) findPreference("result_key");
    result_p.setSummary("( X + Y ) = " + (Float.valueOf(x_p.getText()) + Float.valueOf(y_p.getText())));

}

private void initSummary(Preference p) {
    if (p instanceof PreferenceCategory) {
        PreferenceCategory pCategory = (PreferenceCategory) p;
        for (int i = 0; i < pCategory.getPreferenceCount(); i++) {
            initSummary(pCategory.getPreference(i));
        }
    } else {
        updatePrefSummary(p);
    }
}

private void updatePrefSummary(Preference p) {
    if (p instanceof ListPreference) {
        ListPreference listPref = (ListPreference) p;
        p.setSummary(listPref.getEntry());
    }
    if (p instanceof EditTextPreference) {
        EditTextPreference editTextPref = (EditTextPreference) p;
        p.setSummary(editTextPref.getText());
    }
}

private void checkPrefValueValidity(Preference p) {
    if (p instanceof EditTextPreference) {
        EditTextPreference editTextPref = (EditTextPreference) p;
        if (editTextPref.getText().equals("")) {
            // what do you want to do if the value entered is empty
        } else {
            // maybe only certain values are allowed
        }
    }
}


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = super.onCreateView(inflater, container, savedInstanceState);
    view.setBackgroundColor(getResources().getColor(android.R.color.white));
    return view;
}

@Override
public void onResume() {
    super.onResume();
    getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
}

@Override
public void onPause() {
    super.onPause();
    getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
}

@Override
public void onDestroy() {
    super.onDestroy();
    getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
}

}