SharedPreferences sharedPreferences;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);

    sharedPreferences =  getPreferences(Context.MODE_PRIVATE);
    boolean isSound = sharedPreferences.getBoolean("sound",false);
    // edited here 
    mSoundSwitch.setChecked(isSound);
    if(mSoundSwitch.isChecked()){
        unmute();
    } else {
        mute();
    }
    mSoundSwitch = (Switch) findViewById(R.id.soundSwitch);
    mSoundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                unmute();
                sharedPreferences = getPreferences(Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putBoolean("sound", true);
                editor.apply();

            } else {

                sharedPreferences = getPreferences(Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putBoolean("sound", false);
                editor.apply();

            }
        }

    }

}