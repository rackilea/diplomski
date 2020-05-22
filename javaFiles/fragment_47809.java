Preference prefHelp = findPreference("Help");
prefHelp.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(){
    @Override
    public boolean onPreferenceClick(Preference preference)
    {
        Intent i = ...;
        startActivity(i);
        return true;
    }
});