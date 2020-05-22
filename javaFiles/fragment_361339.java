public class SaltStringPreference {

    private static final String KEY = "a_key";

    private final SharedPreferences prefs;
    private Listener listener;

    private SaltStringPreference(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public static SaltStringPreference from(Context context) {
        return new SaltStringPreference(PreferenceManager.getDefaultSharedPreferences(context));
    }

    public void set(String saltString) {
        prefs.edit().putString(KEY, saltString).apply();
    }

    public String get() {
        return prefs.getString(KEY, "<no_value>");
    }

    /* 
    Note we need to keep a reference to the listener somewhere,
    otherwise it could be garbage collected, see
    https://stackoverflow.com/a/3104265/1219389
    */  
    public void setListener(Listener listener) {
        this.listener = listener;
        prefs.registerOnSharedPreferenceChangeListener(listener);
    }

    public void removeListener() {
        prefs.unregisterOnSharedPreferenceChangeListener(listener);
        this.listener = null;
    }  

    public static abstract class Listener implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if(KEY.equals(key)) {
                onSaltStringChanged(sharedPreferences.getString(KEY, "<no_value>"));
            }
        }

        /**
        * Called when the 'salt string' value changes in SharedPreferences
        * @param saltString The new 'salt string' value
        */
        protected abstract void onSaltStringChanged(String saltString);
    }   
}