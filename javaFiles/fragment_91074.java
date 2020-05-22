Preferences prefs = Preferences.userNodeForPackage(getClass());
boolean hasRunBefore = prefs.getBoolean("hasRunBefore", false);
if (!hasRunBefore) {
    prefs.putBoolean("hasRunBefore", true);

    JOptionPane.showMessageDialog(mainWindow,
        "Welcome to ExampleApp!", "Welcome",
        JOptionPane.INFORMATION_MESSAGE,
        applicationIcon);
}