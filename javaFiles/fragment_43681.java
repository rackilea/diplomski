private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check if it's application's first run
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean state = sharedPreferences.getBoolean("firstrun", false);
        if (!state) {
            Editor editor = sharedPreferences.edit();
            editor.putBoolean("firstrun", true);
            editor.apply();
            startActivity(new Intent(MainActivity.this, SignInActivity.class));
        }
    }