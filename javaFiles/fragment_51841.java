button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            lv = (ListView) findViewById(R.id.your_list_view_id);
            ArrayList<String> list1 = new ArrayList();
            // This is the array adapter, it takes the context of the activity as a 
            // first parameter, the type of list view as a second parameter and your 
           // array as a third parameter.
           ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
             this, 
             android.R.layout.simple_list_item_1,
             your_array_list );

             lv.setAdapter(arrayAdapter); 
        }
});