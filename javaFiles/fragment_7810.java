SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
SharedPreferences.Editor editor = pref.edit();
String background = pref.getString("background", null);
if (background != null) {
erBackground.setBackgroundColor(Color.parseColor(background));
}