protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // There would of course be a better way to populate the data!!
    ArrayList<> transactionList = new ArrayList<>();
    transactionList.add(new Transaction("Mike","Bob"));


    MyListAdapter theAdapter = new MyListAdapter(this, arrayDriverListData);

    ListView transaction_list = (ListView) findViewById(R.id.transaction_list);

    transaction_list.setAdapter(theAdapter);
}