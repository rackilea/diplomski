public class PreferencesHelper {

    private SharedPreferences prefs;

    private static final String FILE_NAME = "com.yourpackage.yourapp.prefs";

    public static final String KEY_CHAPTER = "chapter";

    public PreferencesHelper(Context context) {
        prefs = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }


    /**
     * Save the specified value to the shared preferences
     * 
     * @param key
     *            The key of the value you wish to load
     * @param value
     *            The value to store
     */
    public void save(String key, String value) {
        prefs.edit().putString(key, value).commit();
    }


    /**
     * Load the specified value from the shared preferences
     * 
     * @param key
     *            The key of the value you wish to load
     * @param defValue
     *            The default value to be returned if no value is found
     */
    public int loadString(String key, String defValue) {
        return prefs.getString(key);
    }

}