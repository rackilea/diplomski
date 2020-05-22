private static void saveBooleanProperty(String key, boolean value) 
{
    SharedPreferences preferences = YourClass.getInstance().getSharedPreferences();
    SharedPreferences.Editor editor = preferences.edit();
    editor.putBoolean(key, value);
    editor.commit();
}

private static boolean getBooleanProperty(String key, boolean defaultValueIfNotExist)
{
    SharedPreferences preferences = YourClass.getInstance().getSharedPreferences();
    return preferences.getBoolean(key, defaultValueIfNotExist);
}