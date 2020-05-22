@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);
   SharedPreferences sp = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
}