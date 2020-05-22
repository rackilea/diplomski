@Override
protected void onCreate(Bundle savedInstanceState) {

    ....

    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putBoolean("YOUR_KEY1", true);
    editor.putBoolean("YOUR_KEY2", false);
    editor.putBoolean("YOUR_KEY3", true);
    editor.commit();

    ....
}