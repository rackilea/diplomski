public class SharedPreferenceUtils {

private static final String SP_NAME = "sp";
public static final String LANGUAGE = "language";


// create
public static boolean createSP(Context context, String language) {
    SharedPreferences.Editor editor = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit();
    editor.putString(LANGUAGE, language);
    return editor.commit();
}


// get language
public static String getLanguage(Context context) {
    SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    return sp.getString(LANGUAGE, "");
}

}