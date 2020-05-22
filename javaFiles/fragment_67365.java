@AutoService(CandyPluginModule.class)
public TwixPluginModule extends CandyPluginModule {
  @Override public void configureSnacks() {  // defined on CandyPluginModule
    bindSnack("twix").to(Twix.class);
  }
}