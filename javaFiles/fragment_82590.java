public class BaseApplication extends Application {
    // Store Objectgraph as member attribute or use a Wrapper-class or...

    @Override
    public void onCreate() {
        super.onCreate();
        OBJECTGRAPH = ObjectGraph.create(getInjectionModule());
    } 

    protected Object getInjectionModule() {
        return new RootModule(this);
    }
}