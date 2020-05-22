public class MainActivity extends Activity {
  private static OTBServiceWrapper serviceWrapper;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getServiceWrapper.createSearch(...)
  }

  public OTBServiceWrapper getServiceWrapper() {
    if (serviceWrapper == null) {
      MainActivity.setServiceWrapper(new OTBService().getService());
    }

    return serviceWrapper;
  }

  public static void setServiceWrapper(OTBServiceWrapper serviceWrapper) {
    MainActivity.serviceWrapper = serviceWrapper;
  }
}