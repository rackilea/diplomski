public void setLanguage(String language) {
    mPreferences = getSharedPreferences(LANGUAGE_KEY_FOR_PREFS, MODE_PRIVATE);
    SharedPreferences.Editor editor = mPreferences.edit();
    editor.putString("Language", language);
    editor.apply();
    mListener.onLanguageChanged();
}


public String getLanguage() {
    mPreferences = getSharedPreferences(LANGUAGE_KEY_FOR_PREFS, MODE_PRIVATE);
    return mPreferences.getString("Language", "en");
}