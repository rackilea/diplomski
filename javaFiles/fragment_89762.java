@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Launch SharedPreferences
        prefs = getSharedPreferences("Alarm", MODE_PRIVATE);