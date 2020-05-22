final ListView lv = (ListView) findViewById(R.id.ListView01);

lv.setOnItemClickListener(new OnItemClickListener() {
      public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
        String selectedFromList =(String) (lv.getItemAtPosition(myItemInt));

      }                 
});