public class MyWebServiceExtension extends
  AbstractExtensionId<MyWebServiceExtension.MyWebServiceExt> {

  public static MyWebServiceExtension MyWebServiceExtProvider = 
    new MyWebServiceExtension();

  public MyWebServiceExt createExtension(ExtendedActorSystem system) {
    return new MyWebServiceExt();
  }

  public static class MyWebServiceExt implements Extension {
    private final MyWebServiceClient client = new MyWebServiceClient();

    public MyWebServiceClient getClient() { return client; }
  }
}