public void shw(View view) {

    Dialog dialog=new Dialog(MainActivity.this);
    dialog.setTitle("Dialog Title");     
    dialog.setContentView(R.layout.custadd);    
    ListView lv=(ListView) dialog.findViewById(R.id.listv);    
    String s1[]={"sunday","monday","tuesday"};

     ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, s1 );
    lv.setAdapter(arrayAdapter);
    dialog.show();

}