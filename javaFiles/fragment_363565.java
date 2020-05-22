public class KeyValueDB {
private SharedPreferences sharedPreferences;
private static String PREF_NAME = "prefs";

    public KeyValueDB() {
    // Blank
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static String getUsername(Context context) {
        return getPrefs(context).getString("username_key", "default_username");
    }

    public static void setUsername(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
    editor.putString("username_key", input);
    editor.commit();
    }
}