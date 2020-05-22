@Override
protected void onCreate(Bundle savedInstanceState) {

    ....

    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    //here false is the default value if key is missing 
    boolean value1 = sharedPreferences.getBoolean("YOUR_KEY1", false);
    boolean value2 = sharedPreferences.getBoolean("YOUR_KEY2", false);
    boolean value3 = sharedPreferences.getBoolean("YOUR_KEY3", false);

    ....
}