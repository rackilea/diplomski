SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
String stringArray = settings.getString("myByteArray", null);

if (stringArray != null) {
    String[] split = stringArray.substring(1, stringArray.length()-1).split(", ");
    byte[] array = new byte[split.length];
    for (int i = 0; i < split.length; i++) {
      array[i] = Byte.parseByte(split[i]);
    }
}