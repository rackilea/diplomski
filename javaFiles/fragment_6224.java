public class AppSingleton extends MultiDexApplication {
    private static final String TAG ="AppSingleton" ;


    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferenceUtils.init(this);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}