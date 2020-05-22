@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
    if (prefs.contains("started")) {
        setContentView(R.layout.toolz);
    } else {
        //Add the preference:
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("started",true);
        editor.apply();
        Intent i = new Intent(this, First.class);
        startActivity(i);
        finish();
      }


}