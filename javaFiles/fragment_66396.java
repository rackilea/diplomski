public String saveUserOnAndroid(Context c) {
  SharedPreferences myPrefs = c.getSharedPreferences("myPrefs", 0);
  String savedUser = myPrefs.getString("user", null);

  if(savedUser == null) {
    user = UUID.randomUUID().toString();
    String hashedUser = md5(user);
    SharedPreferences.Editor myPrefsEditor = myPrefs.edit();

    myPrefsEditor.putString("user", hashedUser);
    myPrefsEditor.commit();

    return hashedUser;
  } else {
    return savedUser;
  }
}