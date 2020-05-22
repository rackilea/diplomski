public static void saveInt(Context context, String key, int value) {
        SharedPreferences sharedPref = context.getDefaultSharedPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }