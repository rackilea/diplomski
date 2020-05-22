buttonAlert_oneDelete.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    funDelete(id);
    // reload datafrom Database
    // update datasource of the  simpleCursorAdapter 
    simpleCursorAdapter.notifyDataSetChanged();
    alert1.cancel();
   }
});