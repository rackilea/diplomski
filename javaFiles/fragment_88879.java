public class Session {

 // Declare variable.

 Context context;
 SharedPreferences.Editor editor;
 public static String PREF_NAME = "My_Pref";
 public static int PREF_MODE = 0;
 SharedPreferences prefs;

  public Session(Context context) {
    this.context = context;
    prefs = context.getSharedPreferences(PREF_NAME, PREF_MODE);
    editor = prefs.edit();
  }

  public String setusename(String userid) {
        editor.putString("userid", userid);
        editor.commit();
        return userid;
    }

    public String getusename() {
        return prefs.getString("userid",null);
    }

//Method for destroy session given below.

public void destroySession() {
        editor.clear();
        editor.commit();
    }
}