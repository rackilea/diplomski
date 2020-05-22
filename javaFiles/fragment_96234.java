public class PreferencesData {

    public static void saveString(Context context, String key, String value) {
    SharedPreferences sharedPrefs = PreferenceManager
            .getDefaultSharedPreferences(context);
    sharedPrefs.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defaultValue) {
    SharedPreferences sharedPrefs = PreferenceManager
            .getDefaultSharedPreferences(context);
    return sharedPrefs.getString(key, defaultValue);
    }


    public static void saveBoolean(Context context, String key, Boolean value) {
    SharedPreferences sharedPrefs = PreferenceManager
            .getDefaultSharedPreferences(context);
    sharedPrefs.edit().putBoolean(key, value).commit();
    }

    public static Boolean getBoolean(Context context, String key, Boolean defaultValue) {
    SharedPreferences sharedPrefs = PreferenceManager
            .getDefaultSharedPreferences(context);
    return sharedPrefs.getBoolean(key, defaultValue);
    }
}