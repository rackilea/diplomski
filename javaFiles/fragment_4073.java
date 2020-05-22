if(cursor.moveToFirst()){
    //cursor is no empty, set up list
    adapter = new SimpleCursorAdapter(
  this, 
  R.layout.term_list_layout, 
  cursor, 
  new String[] {"term", "definition"}, 
  new int[] {R.id.term, R.id.definition});

  setListAdapter(adapter);
}else{
    //cursor is empty start new activity
}