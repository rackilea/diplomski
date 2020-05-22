getItemFromServer("5");

 Log.i("msg", item1);

 String item2="item2";
 String item3="item3";

 String[] items={item1, item2, item3};
 ListAdapter adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
 ListView listView=(ListView)findViewById(R.id.listView);

 listView.setAdapter(adapter);