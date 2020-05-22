@Module()
public class ApplicationModule {
    @Provides @Named("ValueA") String provideValueA() {
        return "This is ValueA";
    }
}

@Module(
    addsTo = ApplicationModule.class
)
public class ActivityModule {
    // ValueA comes from ApplicationModule
    @Provides @Named("ValueB") String provideValueB(@Named("ValueA") String valueA) {
        return valueA + " and ValueB";
    }
}

public class DemoApplication extends Application {
  private ObjectGraph graph;

  @Override public void onCreate() {
     super.onCreate();
     graph = ObjectGraph.create(getModules().toArray());
  }

  protected List<Object> getModules() {
      return Arrays.asList(
          new ApplicationModule()
      );
  }

  public void inject(Object object) {
      graph.inject(object);
  }

  public ObjectGraph getObjectGraph() {
      return graph;
  }
}

public class DemoActivity extends Activity {
    private ObjectGraph activityGraph;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the activity graph by .plus-ing our modules onto the application graph.
        DemoApplication application = (DemoApplication) getApplication();
        activityGraph = application.getApplicationGraph().plus(new ActivityModule());

        // Inject ourselves so subclasses will have dependencies fulfilled when this method returns.
        activityGraph.inject(this);
    }

    @Override protected void onDestroy() {
        // Eagerly clear the reference to the activity graph to allow it to be garbage collected as
        // soon as possible.
        activityGraph = null;
        super.onDestroy();
    }
}