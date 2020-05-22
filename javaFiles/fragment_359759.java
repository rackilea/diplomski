@Inject Map<String, Service> services;

public void doSomething(String selection) {
  Service service = services.get(selection);
  // do something with the service
}