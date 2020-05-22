// Activity-level variable scope
private List<RowData> items = new ArrayList<RowData>();
private RowdataAdapter adapter;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    listView1 = (ListView)findViewById(R.id.listView1);

    // adding first item to List, it's optional step
    items.add(new RowData("0:00"));

    adapter = new RowdataAdapter(this, R.layout.listview_item_row, items);
    listView1.setAdapter(adapter);
}