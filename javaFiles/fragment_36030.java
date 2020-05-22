@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);

    select = (Spinner) findViewById(R.id.selectclass);
    username = (EditText) findViewById(R.id.username_view);
    password = (EditText) findViewById(R.id.password_view);

    select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long text) {
            Toast.makeText(SettingsActivity.this,"" + text,Toast.LENGTH_LONG).show();

        }

        public void onNothingSelected(AdapterView<?> arg0) {

        }
    });
}