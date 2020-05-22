@Override
protected void onStop(){
   super.onStop();


  SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
  SharedPreferences.Editor editor = settings.edit();
  editor.putBoolean("isGameOver", isGameOver);

  // Commit the edits!
  editor.commit();
}