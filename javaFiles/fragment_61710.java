public class SettingsUtil {

    private static final String PREF_USER_FILENAME = "user";
    private static final String PREF_TECH_FILENAME = "tech";

    public static void saveNewUser(Context context, User user) {
        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(PREF_USER_FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        ....
        editor.apply();
    }

    public static void addNewTech(Context context, Tech tech) {
        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences(PREF_TECH_FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        ....
        editor.apply();
    }

    ...

}