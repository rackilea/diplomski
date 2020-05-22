mClickButton1.setOnClickListener(new onClickListener(){
   public void onClick(View v) {
     Intent view1_int = new Intent (this, MainActivity.class);
      view1_int.putExtra("Calling Intent" ,"RecyclerView");
      startaActivityForResult(view1_int);


}
});
mClickButton2.setOnClickListener(new onClickListener(){
   public void onClick(View v) {
     Intent view2_int = new Intent (this, MainActivity.class);
      view1_int.putExtra("Calling Intent" ,"Notification action");
      startaActivityForResult(view1_int);


}
});