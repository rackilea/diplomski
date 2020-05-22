ListView lv = (ListView) findViewById(R.id.MessageList);
lv.setAdapter(myAdapter);
lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        MyClassWithGettersSetters objectClicked = (MyClassWithGettersSetters) myAdapter.getItem(arg2);
        Log.d(TAG, "Clicked on object: " + objectClicked);
        objectClicked.getDBID(); // you now have access to the specific object and id
        // do whatever you need to do
    }
});