@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.second);

    edit1 = findViewById(R.id.name);
    edit2 = findViewById(R.id.desigination);
    edit3 = findViewById(R.id.post);

    listView = findViewById(R.id.list_view);

    List list = Collections.synchronizedList(new ArrayList());


    button = findViewById(R.id.list_button);
    button.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onClick(View v) {

            String itemName = edit1.getText().toString();
            String itemDescription = edit2.getText().toString();

            list.add(itemName);
            list.add(itemDescription);

            ArrayAdapter lists1 = new ArrayAdapter(secondActivity.this, 
            android.R.layout.simple_list_item_1, list);
            listView.setAdapter(lists1);
            edit1.setText("");
            edit2.setText("");

        }

    });

}