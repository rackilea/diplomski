public class AS400ServiceFactory {
  private static Map factories = createFactories();

  private static Map createFactories() {
    Map factories = new HashMap();
    factories.put("WBX133", new ServiceFactory(){ public ASService create() { return new Wbx133Service(); } });
    factories.put("WBX134", new ServiceFactory(){ public ASService create() { return new Wbx134Service(); } });
    factories.put("WBX220", new ServiceFactory(){ public ASService create() { return new Wbx220Service(); } });
    // More factories here
    return factories;
  }

  public static AS400Container getInstance(String serviceName) {
    ServiceFactory factory = (ServiceFactory)factories.get(serviceName);
    ASService service = null;
    if (factory != null) {
      service = factory.create();
    }
    // Rest of the method
  }
  private interface ServiceFactory {
    ASService create();
  }
}