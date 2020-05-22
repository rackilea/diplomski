public static void saveData(Context context, String key, String data)
{
SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.putString(key, data);
editor.commit();
}