SharedPreferences settings = getSharedPreferences("preferences", 0);
String silent = settings.getString("reminder", "1");

if (silent.equals("1")) {
  switch1.setChecked(true);
} else {
  switch1.setChecked(false);
}