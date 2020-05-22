// Assume CandyPluginModule extends AbstractModule

@AutoService(CandyPluginModule.class)
public TwixPluginModule extends CandyPluginModule {
  @Override public void configure() {
    MapBinder<String, Snack> mapBinder
       = MapBinder.newMapBinder(binder(), String.class, Snack.class);
    mapBinder.addBinding("twix").to(Twix.class);
  }
}