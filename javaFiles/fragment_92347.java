SharedPreferences pref;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

    Btn1 = (Button)findViewById(R.id.EnabledBtn);
    Btn2 = (Button)findViewById(R.id.disbledBtn);

  /*when the app is launched, it will check if the button should be 
    enabled by getting the value from sharedpreferences. If the value was 
    not already set, then it chooses false as the default value*/

    boolean enabled = pref.getBoolean("isEnabled",false);
    Btn2.setEnabled(enabled);

  /*When btn1 is clicked, you want to store value true to 
    sharedpreferences so that it will be the value that will be 
    retrieved when app is restarted*/

    Btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pref.edit().putBoolean("isEnabled",true).apply();
            Btn2.setEnabled(true);
        }
    });
}