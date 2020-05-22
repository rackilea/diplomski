protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ArrayList<Details> detail = new ArrayList<>();

    detail.add(new Details(R.string.list_1, price_1,getResources().getColor(R.color.color_category_1)));

    // More detail           
    DetailsAdapter adapter = new DetailsAdapter(this, detail);
    ListView listView = (ListView) findViewById(R.id.list);
    listView.setAdapter(adapter);

    // Click event
    listView.setOnItemClickListener(new setOnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            // Do what you need...
        }
    });
}