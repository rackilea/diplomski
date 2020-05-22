public Business1Module extends AbstractModule {
  @Override public void configure() {
    MapBinder<String, BookingInterface> bookingBinder =
        MapBinder.newMapBinder(binder(), String.class, BookingInterface.class);
    bookingBinder.addBinding("business1").to(Business1BookingInterface.class);
    MapBinder<String, InvoiceInterface> invoiceBinder =
        MapBinder.newMapBinder(binder(), String.class, InvoiceInterface.class);
    invoiceBinder.addBinding("business1").to(Business1InvoiceInterface.class);
  }
}