public class SnacksModule extends AbstractModule {
  protected void configure() {
    MapBinder<String, Snack> mapbinder
           = MapBinder.newMapBinder(binder(), String.class, Snack.class);
    mapbinder.addBinding("twix").to(Twix.class);
    mapbinder.addBinding("snickers").to(Snickers.class);
    mapbinder.addBinding("skittles").to(Skittles.class);
  }
}