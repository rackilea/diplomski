private static enum LoginWindow {
    CLIENT, ADMIN;
}
...
Preferences prefs = Preferences.userNodeForPackage(this);
if (client.getSetAsDefaultCheckbox().getValue())
    prefs.put("PREF_WIND",LoginWindow.CLIENT.name());
else if (admin.getSetAsDefaultCheckbox().getValue())
    prefs.put("PREF_WIND",LoginWindow.ADMIN.name());