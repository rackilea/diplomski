public class Settings {
    public static boolean getDoSomethingOptionValue(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getString("doSomethingOptionValue", "false");
    }
}