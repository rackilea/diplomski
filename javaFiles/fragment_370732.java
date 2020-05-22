public class Application extends android.app.Application{
    @Override
    public void onCreate() {
        Parse.initialize(this, "redacted", "redacted");
        ParseFacebookUtils.initialize(this);
        initSingleton();
    }

    protected void initSingleton() {
        ParseUserSingleton.initInstance();
    }
}