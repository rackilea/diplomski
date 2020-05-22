@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main3);
    ListView listView = (ListView) findViewById(R.id.list_data);
    CustomAdapter customAdapter = new CustomAdapter(this);
    listView.setAdapter(customAdapter);
}