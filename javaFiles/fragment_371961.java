public void updateUi(){
    final ListView listview = (ListView) findViewById(R.id.listview);

    final ArrayList<String> list = new ArrayList<String>();

    for (int i = 0; i < ALTS.size(); i++) {
        list.add(ALTS.get(i).getSeriesName());
    }

    final StableArrayAdapter adapter = new StableArrayAdapter(this,
      android.R.layout.simple_list_item_1, list);
    listview.setAdapter(adapter);

    //...
}