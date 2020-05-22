class ConfigurableNode extends Node {
  public ConfigurableNode(Settings settings, Collection<Class<? extends Plugin>> classpathPlugins) {
    super(InternalSettingsPreparer.prepareEnvironment(preparedSettings, null), 
      Version.CURRENT, 
      classpathPlugins);
  }
}