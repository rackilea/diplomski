@Override
protected void onStop() {
    super.onStop();
    SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    SharedPreferences.Editor editor = saved_values.edit();
    edit.putString("key", "stringToBeSaved")

    editor.commit();
}