@Override
protected void onStop(){
   super.onStop();

  SharedPreferences prefs = getPreferences(MODE_PRIVATE);
  SharedPreferences.Editor editor = prefs.edit();
  editor.putString("password",password); 
  editor.commit();