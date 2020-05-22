public void ArraySubs() {
Bundle b = getIntent().getExtras();
String[] subChoices = b.getStringArray("selectedItems");
ListView lv = (ListView) findViewById(R.id.outputList);

ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, subChoices);
lv.setAdapter(adapter);
};