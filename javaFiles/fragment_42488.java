authorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
       String author = authorsListView.getItemAtPosition(position).toString();                 
  }
 });