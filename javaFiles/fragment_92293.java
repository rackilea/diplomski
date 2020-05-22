if(enterNumber.getText().getString().equals("6")){
  Intent i = new Intent(this, SixTimesTables.class);
  i.putExtra("Value1", 5);
  i.putExtra("Value2", 6);
  // set the request code to any code you like,
  // you can identify the callback via this code
  startActivityForResult(i, REQUEST_CODE);
}