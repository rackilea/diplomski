@Override
protected void configure() {
  MapBinder<String, Service> mapBinder = MapBinder.newMapBinder(binder(), String.class, Service.class);
  mapBinder.addBinding("serviceA").to(ServiceAImpl.class);
  mapBinder.addBinding("serviceB").to(ServiceBImpl.class);
}