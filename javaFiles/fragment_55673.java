import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private SharedPreferences.Editor editor;
    private Context mContext;
    private SharedPreferences prefs;
    private final String LANGUAGE = "language";
    private final String PREF = "user_data";

    public PrefManager(Context mContext) {
        this.mContext = mContext;
    }

    public String getLanguage() {
        this.prefs = this.mContext.getSharedPreferences(PREF, 0);
        return this.prefs.getString(LANGUAGE, "en");
    }

    public void setLanguage(String language) {
        this.editor = this.mContext.getSharedPreferences(PREF, 0).edit();
        this.editor.putString(LANGUAGE, language);
        this.editor.apply();
    }
}