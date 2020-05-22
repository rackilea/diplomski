public class ServiceManager {
  private final Map<String, Service> serviceMap;

  @Inject
  public ServiceManager(Map<String, Service) serviceMap) {
    this.serviceMap = serviceMap;
  }

  // This is just one way to do it. It depends on how your UI works
  public void startAll(List<String> serviceList) {
    for(String serviceName : serviceList) {
      serviceMap.get(serviceName).start();
    }
  }
}