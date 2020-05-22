private void savePluginSettings() {
  // saves plugin preferences at the workspace level
  Preferences prefs =
    //Platform.getPreferencesService().getRootNode().node(Plugin.PLUGIN_PREFEERENCES_SCOPE).node(MY_PLUGIN_ID);
    new InstanceScope().getNode(MY_PLUGIN_ID); // does all the above behind the scenes

  prefs.put(KEY1, this.someStr);
  prefs.put(KEY2, this.someBool);

  try {
    // prefs are automatically flushed during a plugin's "super.stop()".
    prefs.flush();
  } catch(BackingStoreException e) {
    //TODO write a real exception handler.
    e.printStackTrace();
  }
}

private void loadPluginSettings() {
  Preferences prefs = new InstanceScope().getNode(MY_PLUGIN_ID);
  // you might want to call prefs.sync() if you're worried about others changing your settings
  this.someStr = prefs.get(KEY1);
  this.someBool= prefs.getBoolean(KEY2);
}