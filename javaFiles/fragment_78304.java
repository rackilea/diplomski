ListView listView = (ListView) findViewById(R.id.mylist);  

  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
      android.R.layout.simple_list_item_1, android.R.id.text1, values);

       listView.setAdapter(adapter);