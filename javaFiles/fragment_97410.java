ListView listView = new ListView(this);
    stringArrayList.add("ONE");
    stringArrayList.add("TWO");
    stringArrayList.add("THREE");
    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stringArrayList);
    listView.setAdapter(arrayAdapter);
    setContentView(listView);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        TextView previousView = null; // to hold the previous clicked view
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            TextView textView = (TextView)view.findViewById(android.R.id.text1);
            if(previousView != null) {
                // revert the previous view when a new item is clicked
                previousView.setGravity(Gravity.CENTER_VERTICAL);
            }
            textView.setGravity(Gravity.CENTER);
            previousView = textView;
        }
    });