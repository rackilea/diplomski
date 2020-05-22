private static final String GLOBAL_PREFERENCES = "a.nice.identifier.for.your.preferences.goes.here";

public static void savePreferences(@NonNull Context context, String key, int value) {
    SharedPreferences sharedPreferences = context.getSharedPreferences(GLOBAL_PREFERENCES, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt(key, value);
    editor.apply();
}

public static int loadPreferences(@NonNull Context context, String key, int defaultValue) {
    SharedPreferences sharedPreferences = context.getSharedPreferences(GLOBAL_PREFERENCES, Context.MODE_PRIVATE);
    return sharedPreferences.getInt(key, defaultValue);
}