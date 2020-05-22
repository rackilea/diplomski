public class Settings extends ActionBarActivity {
    // Create a constant for the setting that you're saving
    private static final String SETTING_CHECK_BOX = "checkbox_setting";

    private CheckBox mCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);

        // Set the initial state of the check box based on saved value
        mCheckBox.setChecked(isCheckedSettingEnabled());
    }

    @Override
    public void onPause() {
        super.onPause();

        // Persist the setting. Could also do this with an OnCheckedChangeListener.
        setCheckedSettingEnabled(mCheckBox.isChecked());
    }

    /**
     * Returns true if the setting has been saved as enabled,
     * false by default
     */
    private boolean isCheckedSettingEnabled() {
        return PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean(SETTING_CHECK_BOX, false);
    }

    /**
     * Persists the new state of the setting
     * 
     * @param enabled the new state for the setting
     */
    private void setCheckedSettingEnabled(boolean enabled) {
        PreferenceManager.getDefaultSharedPreferences(this)
                .edit()
                .putBoolean(SETTING_CHECK_BOX, enabled)
                .apply();
    }
}