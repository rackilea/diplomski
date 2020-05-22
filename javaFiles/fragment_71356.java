public class MyApplication extends Application {
    public static SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();

        preferences = getSharedPreferences( getPackageName() + "_preferences", MODE_PRIVATE);