@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_url_list);

    context = getApplicationContext();
    database = new DatabaseHelper(context);
    listOfUrl = (RecyclerView) findViewById(R.id.url_list);
    find = (Button) findViewById(R.id.findBtn);
    cancel = (Button) findViewById(R.id.cancelBtn);

    makeItPopUp();

    listOfUrl.setLayoutManager(new LinearLayoutManager(this));
    listOfUrl.setHasFixedSize(true);
    listOfUrl.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    adapter = new ListAdapter(fillList(), context);
    adapter.setListener(new SelectCountryDialogListener() {
            @Override
            public void onClick(int pos) {
                ItemView item = adapter.getItem(pos);
            }

            @Override
            public void onLongClick(int pos) {
                ItemView item = adapter.getItem(pos);
            }
        });
    listOfUrl.setAdapter(adapter);

    selectedItems = new ArrayList<Boolean>(Arrays.asList(new Boolean[listOfUrl.getAdapter().getItemCount()]));
    Collections.fill(selectedItems, Boolean.FALSE);

    find.setOnClickListener(this);
    cancel.setOnClickListener(this); 
}