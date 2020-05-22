public class MyApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    public ApplicationComponent getOrCreateApplicationComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .myAppModule(new MyAppModule(this))
                    .networkModule(new NetworkModule())
                    .build();
        }
        return mApplicationComponent;
    }
}