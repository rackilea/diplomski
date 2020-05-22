LinearLayout ll,ll2;
SharedPreference pref; 

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    pref = getSharedPreferences("MyApplication", Activity.MODE_PRIVATE);

    location_btn = (Button)findViewById(R.id.location_btn);
    menu_btn = (Button)findViewById(R.id.bt_menu);
    mButton = (Button) findViewById(R.id.buttone);
    mEdit = (EditText) findViewById(R.id.edittexte);
    ll2 = (LinearLayout)findViewById(R.id.llayout);

    // Check the preference value when activity is launched each time and hide of the button was pressed before
    if(pref.getBoolean("ButtonPressed", false)) ll2.setVisibility(View.GONE);

    mButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            number = mEdit.getText().toString();
            mEdit.setText("");
            // Save the sate of the button pressed in the SharedPreference
            pref.edit().putBoolean("ButtonPressed", true).apply();

            ll2.setVisibility(View.GONE);
        }
    });
}