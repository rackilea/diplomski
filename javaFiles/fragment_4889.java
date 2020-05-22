public class ActivityManager {

    private static ActivityManager instance = null;

    private SharedPreferences sharedPref;

    private Context context_;

    private final String prefName = "preferencesHandler";

    public static ActivityManager getInstance(Context context) {
        if (instance == null) {
            instance = new ActivityManager(context);
        }

        return instance;
    }

    private ActivityManager(Context context) {
        context_ = context;
        sharedPref = context_.getSharedPreferences(prefName,Context.MODE_PRIVATE);
    }

    public void saveActivity(int ID) {
        editor = sharedPref.edit();
        // Key,Value
        editor.putInt("activity_id",ID);

        editor.commit();
    }

    public int getActivityID() {
        // Key, Default Value
        return sharedPref.getInt("activity_id",0);
    }
}