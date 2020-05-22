public class SharedPreferencesManager {
    SharedPreferences pref;
    Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "my_preferences";

    //Preferences keys
    public static final String MY_KEY_ONE = "myKeyOne";

    // Constructor
    public SharedPreferencesManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    //STORE VALUE
    public void storeValue(String key, String value){ //value can be of any type you need
        //Save value
        editor.putString(key, value);

        // DONT FORGET to commit changes
        editor.commit();

    }

    //GET VALUE
    public String getStringValue(String key){
        return pref.getString(key, null);
    }

    //REMOVE ONE VALUE
    public void removeValue(String key){
        editor.remove(key);
        editor.commit();
    }

    //CLEAR DATA
    public void clearAllValues(){
        editor.clear();
        editor.commit();
    }

}