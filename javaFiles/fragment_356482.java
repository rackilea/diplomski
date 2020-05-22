public class ServiceModule extends AbstractModule {
  protected void configure() {
    MapBinder<String, Service> mapbinder
        = MapBinder.newMapBinder(binder(), String.class, Service.class);
    mapbinder.addBinding("service1").to(Service1.class).in(Singleton.class);
    mapbinder.addBinding("service2").to(Service2.class);
    // Define ALL the services here, not just the ones being used.
    // You could also look this up from a ClassLoader or read from a configuration file if you want
  }
}