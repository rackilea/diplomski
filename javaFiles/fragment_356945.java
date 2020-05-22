@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_saved_password);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    ArrayList<String> addArray getIntent().getExtras().getStringArrayList("SavedPassword");
    ListView listView = (ListView)findViewById(R.id.listView);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,addArray);
    listView.setAdapter(adapter);
}