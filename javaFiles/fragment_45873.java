protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

            // get the a writable DB, in case it's not existing it gets created.
    DataHandlerDB.createDB(this);
    // get stuff out of DB
    moduleList = DataHandlerDB.findAll(this);

    adapter = new ArrayAdapter<Module>(this,
            android.R.layout.simple_list_item_1, moduleList);
    setListAdapter(adapter);
}