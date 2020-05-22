SharedPreferences settings = getSharedPreferences("PREFERENCES", MODE_PRIVATE);
if(settings.getString("USER_NAME", "").equals("")) {
    //User has to enter the name
    //Do the specific action
    String user_name = ...
    SharedPreferences.Editor editor = settings.edit();
    editor.putString("USER_NAME", user_name);
    editor.commit();
}