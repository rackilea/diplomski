myList.setOnItemLongClickListener(new OnItemLongClickListener() {
  @Override public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
   //... code to save mp3 file...
   Toast.makeText(context, "File saved as ringtone", Toast.LENGTH_LONG).show();
   return false;
  }