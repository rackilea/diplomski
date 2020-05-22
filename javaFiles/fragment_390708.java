public void onAddItem(View v) {
    EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
    String itemText = etNewItem.getText().toString();
    itemsAdapter.add(new Todo(itemText)); // Add items to new Adapter type
    etNewItem.setText("");
    writeItems();
}