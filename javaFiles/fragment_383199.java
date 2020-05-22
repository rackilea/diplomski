public class PreferencesData {

public static void saveInt(Context context, String key, int value) {
    SharedPreferences sharedPrefs = PreferenceManager
            .getDefaultSharedPreferences(context);
    sharedPrefs.edit().putInt(key, value).commit();
}

public static int getInt(Context context, String key, int defaultValue) {
    SharedPreferences sharedPrefs = PreferenceManager
            .getDefaultSharedPreferences(context);
    return sharedPrefs.getInt(key, defaultValue);
}
}