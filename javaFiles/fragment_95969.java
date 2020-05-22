@Override
public void onCreate() {
    super.onCreate();

    RoboGuice.setUseAnnotationDatabases(false);
    RoboGuice.getOrCreateBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE,
            RoboGuice.newDefaultRoboModule(this), new SomeModule(this));
}