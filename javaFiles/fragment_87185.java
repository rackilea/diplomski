SharedPreferences prefs = getPreferences(MODE_PRIVATE);
Boolean[] list = new Boolean[10];
StringBuilder str = new StringBuilder();
for (int i = 0; i < list.length; i++) {
str.append(list[i]).append(",");
}
prefs.edit().putBoolean("keys", str.toString()).commit();