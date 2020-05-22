public class SharedPreferencesManager {

    private static final String APP_PREFS = "AppPrefsFile";
    private static final String KEY_FOR_SOMETHING = "KEY_FOR_SOMETHING";

    private SharedPreferences sharedPrefs;
    private static SharedPreferencesManager instance;



    private SharedPreferencesManager(Context context) {
        sharedPrefs =
                context.getApplicationContext().getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }


    public static synchronized SharedPreferencesManager getInstance(Context context){
        if(instance == null)
            instance = new SharedPreferencesManager(context);

        return instance;
    }

    public void setSomething(String something) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(KEY_FOR_SOMETHING, something);
        editor.apply();
    }

    public String getSomeKey() {
        String someValue = sharedPrefs.getString(KEY_FOR_SOMETHING, null);
        return someValue;
    }
}