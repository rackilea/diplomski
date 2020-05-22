public class AppPreferences {
                    private static SharedPreferences mPrefs;
                    private static SharedPreferences.Editor mPrefsEditor;

                    public static Set<String> getName(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getStringSet("nameList", null);
    }

    public static void setName(Context ctx, ArrayList<String> value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        Set<String> set = new HashSet<>();
        set.addAll(value);
        mPrefsEditor.putStringSet("nameList", set);
        mPrefsEditor.commit();
    }

public static void clearNameList(Context ctx) {
       mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        Set<String> set = new HashSet<>();
        mPrefsEditor.putStringSet("nameList", set);
        mPrefsEditor.commit();
    }
            }