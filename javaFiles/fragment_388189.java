public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setupCrashReporting();
    }

    protected void setupCrashReporting() {
        CrashlyticsCore core = new CrashlyticsCore.Builder()
                .disabled(BuildConfig.DEBUG)
                .build();

        Crashlytics crashlytics = new Crashlytics.Builder()
                .core(core)
                .build();

        Fabric.with(this, crashlytics);
    }
}