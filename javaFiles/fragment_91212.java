public enum MySingleton {
  INSTANCE;

  private final HashMap<SomeEnumType, UserSettings> settings;
  {
    settings = new HashMap<SomeEnumType, UserSettings>();
    settings.put(...,...);
  }

  public final UserSettings getSettings(SomeEnumType enumType) {
     return settings.get(enumType);
  }

}