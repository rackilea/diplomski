@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    SharedPreferences prefs =getSharedPreferences("packagename", MODE_PRIVATE);
    if (prefs.getBoolean("firstrun", true)) {
        Intent intent = new Intent(MainActivity.this,AnotherActivity.class);
        startActivity(intent);
        prefs.edit().putBoolean("firstrun", false).commit();
    }
    else{}
}