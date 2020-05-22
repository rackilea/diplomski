public class CustomApplication extends Application {
    @Override
    public void onCreate() {
         super.onCreate();
         Bootstrap.INSTANCE.setup();
    }
}

@Component
@Singleton
public interface _Bootstrap {
    void initialize(ActivityA activityA);
    //void initiali...
}

public enum Bootstrap {
    INSTANCE;

    private _Bootstrap bootstrap;

    void setup() {
        bootstrap = Dagger_Bootstrap.create();
    }

    public _Bootstrap getBootstrap() {
        return bootstrap;
    }
}