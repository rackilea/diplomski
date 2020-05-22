public void search(View v) {

    setContentView(R.layout.list_view);

    TestAdapter mDbHelper = new TestAdapter(getBaseContext());
    mDbHelper.open();

    ArrayAdapter<Horario> adapter = new MyListAdapter(mDbHelper.getorigem());
    ListView list = (ListView) findViewById(R.id.list_view);
    list.setAdapter(adapter);

    mDbHelper.close();

}