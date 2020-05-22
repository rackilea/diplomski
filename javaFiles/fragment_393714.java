mainListView.setAdapter( listAdapter ); 
mainListView.setOnItemClickListener(new OnItemClickListener(){
   public void onItemClick(AdapterView<?> parent, View view, int position,
        long id) {

      try {
        new AsyncAction1().execute();
      }catch(Exception e) {
        e.printStackTrace();
   }
});