class NameSettings {
  private SharedPreferences prefs;

  @Inject NameSettings(SharedPreferences prefs) {
    this.prefs = prefs;
  }

  String getName() { return /* load from prefs */ }
  void setName(String name) { /* save to prefs */ }
}