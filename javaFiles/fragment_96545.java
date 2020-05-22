public void for123(View view){
  SharedPreferences sharedPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
  String name = sharedPref.getString("username", "");
  numTxt.setText(name + " ");
}

@Override
public void onResume(){
  super.onResume();
  for123(/* Whatever view you are in*/);
}