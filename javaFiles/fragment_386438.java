public class MyApplication extends Application {

@Override
public void onCreate() {
    super.onCreate();
    if (TextUtils.equals(SharedPreferenceUtils.getLanguage(this), "en")) {
        LanguageUtils.startLanguage(getApplicationContext(), "en");
    } else {
        LanguageUtils.startLanguage(getApplicationContext(), "zh");
    }
}

}