if (preference instanceof EditTextPreference) {
EditTextPreference newPreference = (EditTextPreference) preference;
    if (newPreference.getKey().matches("pref_reset_savings")){
        if(newPreference.getText().matches("CONFIRM")){
            Log.i("reset", "confirmed");
        }
    }
}