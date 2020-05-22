ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.layer_list_item, R.id.layers_list_item_text);

adapter.add(createLayerListItem("Test 1"));
adapter.add(createLayerListItem("Test 2"));
adapter.add(createLayerListItem("Test 3"));


public String createLayerListItem(String text) {
        View v = View.inflate(this, R.layout.layer_list_item, null);
        TextView text_view = (TextView) v
                .findViewById(R.id.layers_list_item_text);
        text_view.setText(text);
        return text_view.getText().toString();
    }