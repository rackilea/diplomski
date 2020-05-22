private class MyOnClickListener implements OnClickListener {
  private final int mId;
  public MyOnClickListener(int id) {
    mId = id;
  }

  public void onClick(View v) {
      Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
      intent.putExtra("", mId);
      startActivity(intent);
   }

} 

 for ( int i = 0; i< IDList.size() ; i++)   {       
        btnDetails.setOnClickListener(new MyOnClickListener(IDList.get(i)));
 }