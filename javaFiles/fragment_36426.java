protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.previous_practices_layout);

    Bundle extras = getIntent().getExtras();
    hours = extras.getInt("Hours");
    minutes = extras.getInt("Minutes");
    description=extras.getString("Description");
    // date = extras.getString("Date");

    practiceList=(ListView)findViewById(R.id.practiceList);
    ArrayList<String> listItems = new ArrayList<String>();
    listItems.add(description);
    adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,listItems);
    practiceList.setAdapter(adapter);
    adapter.notifyDataSetChanged();
}