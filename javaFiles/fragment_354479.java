setContentView(R.layout.main);
    ListView listView = (ListView) findViewById(R.id.myListView);
    SharedPreferences pref = getSharedPreferences("dawaaData", MODE_PRIVATE);
    String items = pref.getString("subject", "item1,item2,item3");
    String[] listItems = items.split(",");
    listView.setAdapter(new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, listItems));