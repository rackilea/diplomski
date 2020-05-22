public class TodoApplication extends Application {

private static AppComponent components;

@Override
public void onCreate() {
    super.onCreate();
    components = DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .build();
}


public static AppComponent getAppComponent() {
    return components;
}