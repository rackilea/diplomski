public void AddItem(View v) {
    EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
    String itemText = etNewItem.getText().toString();
    items.add(itemText); // change the adapter to your ArrayList
    etNewItem.setText("");
    itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
    lvItems.setAdapter(itemsAdapter);
}